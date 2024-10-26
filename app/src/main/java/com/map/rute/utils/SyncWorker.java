package com.map.rute.utils;

import static androidx.camera.core.impl.utils.ContextUtil.getApplicationContext;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import retrofit2.Response;

public class SyncWorker extends Worker {

    public SyncWorker(Context context, WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        // Llamar al servicio de sincronización
        SyncService.startSync(getApplicationContext());
        return Result.success();
    }
}

