package com.map.rute.ui.home;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.common.util.concurrent.ListenableFuture;
import com.map.rute.R;
import com.map.rute.databinding.FragmentHomeBinding;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class HomeFragment extends Fragment {
    ImageButton capture, toggleFlash, flipCamera;
    private PreviewView previewView;
    int cameraFacing = CameraSelector.LENS_FACING_BACK;
    private ImageCapture imageCapture;

    private final ActivityResultLauncher<String> permissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {
        if (result) {
            startCamera(cameraFacing);
        }
    });

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        previewView = binding.getRoot().findViewById(R.id.cameraPreview);
        capture = binding.getRoot().findViewById(R.id.capture);
        toggleFlash = binding.getRoot().findViewById(R.id.toggleFlash);
        flipCamera = binding.getRoot().findViewById(R.id.flipCamera);

        if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            permissionLauncher.launch(Manifest.permission.CAMERA);
        }else {
            startCamera(cameraFacing);
        }

        flipCamera.setOnClickListener(view -> {
            cameraFacing = (cameraFacing == CameraSelector.LENS_FACING_BACK) ? CameraSelector.LENS_FACING_FRONT : CameraSelector.LENS_FACING_BACK;
            startCamera(cameraFacing);
        });

        return binding.getRoot();
    }

    public void startCamera(int cameraFacing){
        int aspectRatio =  aspectRatio(previewView.getWidth(), previewView.getHeight());
        ListenableFuture<ProcessCameraProvider> listenableFuture = ProcessCameraProvider.getInstance(requireContext());

        listenableFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = listenableFuture.get();
                Preview preview = new Preview.Builder().setTargetAspectRatio(aspectRatio).build();

                imageCapture = new ImageCapture.Builder()
                        .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                        .setTargetRotation(requireActivity().getWindowManager().getDefaultDisplay().getRotation())
                        .build();

                CameraSelector cameraSelector = new CameraSelector.Builder()
                        .requireLensFacing(cameraFacing)
                        .build();

                cameraProvider.unbindAll();

                Camera camera = cameraProvider.bindToLifecycle(
                        HomeFragment.this,
                        cameraSelector,
                        preview,
                        imageCapture
                );

                capture.setOnClickListener(view -> {
                    if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        permissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    } else {
                        takePicture();
                    }
                });

                toggleFlash.setOnClickListener(view -> setFlashIcon(camera));

                preview.setSurfaceProvider(previewView.getSurfaceProvider());

            } catch (ExecutionException | InterruptedException e) {
                Log.e("CameraError", "Error starting camera", e);
            }

        }, ContextCompat.getMainExecutor(requireContext()));
    }

    public void takePicture() {
        File file = new File(requireContext().getExternalFilesDir(null), System.currentTimeMillis() + ".jpg");
        ImageCapture.OutputFileOptions outputFileOptions = new ImageCapture.OutputFileOptions.Builder(file).build();

        imageCapture.takePicture(outputFileOptions, Executors.newCachedThreadPool(), new ImageCapture.OnImageSavedCallback() {
            @Override
            public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                requireActivity().runOnUiThread(() ->
                        Toast.makeText(requireContext(), "Imagen guardada en: " + file.getPath(), Toast.LENGTH_SHORT).show()
                );
                startCamera(cameraFacing);
            }

            @Override
            public void onError(@NonNull ImageCaptureException exception) {
                requireActivity().runOnUiThread(() ->
                        Toast.makeText(requireContext(), "Falló el guardado: " + exception.getMessage(), Toast.LENGTH_SHORT).show()
                );
                startCamera(cameraFacing);
            }
        });
    }

    public void setFlashIcon(Camera camera){
        Integer torchState = camera.getCameraInfo().getTorchState().getValue();
        if (torchState != null && torchState == 0) {
            camera.getCameraControl().enableTorch(true);
            toggleFlash.setImageResource(R.drawable.round_flash_off_24);
        } else if (torchState != null) {
            camera.getCameraControl().enableTorch(false);
            toggleFlash.setImageResource(R.drawable.round_flash_on_24);
        } else {
            Toast.makeText(getContext(), "Unable to get torch state", Toast.LENGTH_SHORT).show();
        }
    }

    public int aspectRatio(int width, int height){
        double previewRatio = (double) Math.max(width, height) / Math.min(width, height);
        if (Math.abs(previewRatio - 4.0 / 3.0) <=  Math.abs(previewRatio - 16.0 / 9.0)){
            return AspectRatio.RATIO_4_3;
        } else {
            return AspectRatio.RATIO_16_9;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
