package com.map.rute.api;

import retrofit2.Call;
import retrofit2.Callback;

import java.util.List;

public class SupaBaseDatabaseService {

    private final SupabaseService supabaseService;

    public SupaBaseDatabaseService(SupabaseService supabaseService) {
        this.supabaseService = supabaseService;
    }

    // User operations
    public void createUser(User user, Callback<User> callback) {
        Call<User> call = supabaseService.createUser(user);
        call.enqueue(callback);
    }

    public void getUserById(String id, Callback<User> callback) {
        Call<User> call = supabaseService.getUserById(id);
        call.enqueue(callback);
    }

    public void getAllUsers(Callback<List<User>> callback) {
        Call<List<User>> call = supabaseService.getAllUsers();
        call.enqueue(callback);
    }

    // Photo operations
    public void createPhoto(Photo photo, Callback<Photo> callback) {
        Call<Photo> call = supabaseService.createPhoto(photo);
        call.enqueue(callback);
    }

    public void getPhotoById(String id, Callback<Photo> callback) {
        Call<Photo> call = supabaseService.getPhotoById(id);
        call.enqueue(callback);
    }

    public void getPhotosByUserId(String userId, Callback<List<Photo>> callback) {
        Call<List<Photo>> call = supabaseService.getPhotosByUserId(userId);
        call.enqueue(callback);
    }

    // Tag operations
    public void createTag(Tag tag, Callback<Tag> callback) {
        Call<Tag> call = supabaseService.createTag(tag);
        call.enqueue(callback);
    }

    public void getTagById(String id, Callback<Tag> callback) {
        Call<Tag> call = supabaseService.getTagById(id);
        call.enqueue(callback);
    }

    public void getAllTags(Callback<List<Tag>> callback) {
        Call<List<Tag>> call = supabaseService.getAllTags();
        call.enqueue(callback);
    }

    // PhotoTag operations
    public void createPhotoTag(PhotoTag photoTag, Callback<PhotoTag> callback) {
        Call<PhotoTag> call = supabaseService.createPhotoTag(photoTag);
        call.enqueue(callback);
    }

    public void getTagsByPhotoId(String photoId, Callback<List<PhotoTag>> callback) {
        Call<List<PhotoTag>> call = supabaseService.getTagsByPhotoId(photoId);
        call.enqueue(callback);
    }
}


