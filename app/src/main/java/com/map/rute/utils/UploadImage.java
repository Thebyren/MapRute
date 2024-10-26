package com.map.rute.utils;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.map.rute.api.SupabaseClient;
import com.map.rute.api.SupabaseService;

import java.io.File;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.io.IOException;
import java.util.Objects;

public class UploadImage {

    public void uploadImageToSupabase(Context context, Uri imageUri) {
        File file = new File(Objects.requireNonNull(imageUri.getPath()));

        // Crear el cuerpo de la imagen
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        // Llamada a Retrofit
        SupabaseService service = SupabaseClient.getService();
        Call<ResponseBody> call = service.uploadImage(body);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        assert response.body() != null;
                        String responseBody = response.body().string();
                        Log.d("Upload Success", "Imagen subida con éxito: " + responseBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("Upload Error", "Error en la respuesta: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Upload Error", "Fallo al subir la imagen", t);
            }
        });
    }
}
