package com.map.rute.utils;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.map.rute.api.SupabaseClient;
import com.map.rute.api.SupabaseService;
import com.map.rute.data.db.LocalDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SyncService {
    private final LocalDatabase localDatabase;
    private final SupabaseService supabaseService;

    public SyncService(Context context) {
        this.localDatabase = new LocalDatabase(context); // Usar LocalDatabase
        this.supabaseService = SupabaseClient.getService();
    }

    public void syncPhotos() {
        List<Photo> unsyncedPhotos = localDatabase.getUnsyncedPhotos();

        for (Photo photo : unsyncedPhotos) {
            // Usar createPhoto para subir la foto a Supabase
            supabaseService.createPhoto(photo).enqueue(new Callback<Photo>() {
                @Override
                public void onResponse(@NonNull Call<Photo> call, @NonNull Response<Photo> response) {
                    if (response.isSuccessful()) {
                        // Marcar como sincronizada la foto
                        localDatabase.markAsSynced(photo.getId());
                    } else {
                        // Manejar el error de respuesta aquí (por ejemplo, loggear el error)
                        Log.e("SyncService", "Error en la respuesta: " + response.message());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Photo> call, @NonNull Throwable t) {
                    // Manejar la falla en la llamada (conexión fallida, etc.)
                    Log.e("SyncService", "Error en la sincronización: ", t);
                }
            });
        }
    }
}
