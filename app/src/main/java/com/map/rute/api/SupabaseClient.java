package com.map.rute.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SupabaseClient {

    private static final String SUPABASE_URL = "https://<YOUR-SUPABASE-URL>.supabase.co/";
    private static final String SUPABASE_KEY = "Bearer <YOUR-SUPABASE-ANON-KEY>";
    private static Retrofit retrofit = null;

    public static SupabaseService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(SUPABASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(SupabaseService.class);
    }
}

