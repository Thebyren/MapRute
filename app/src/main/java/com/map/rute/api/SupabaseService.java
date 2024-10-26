package com.map.rute.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SupabaseService {
    // User operations
    @POST("users")
    Call<User> createUser(@Body User user);

    @GET("users/{id}")
    Call<User> getUserById(@Path("id") String id);

    @GET("users")
    Call<List<User>> getAllUsers();

    // Photo operations
    @POST("photos")
    Call<Photo> createPhoto(@Body Photo photo);

    @GET("photos/{id}")
    Call<Photo> getPhotoById(@Path("id") String id);

    @GET("photos/user/{userId}")
    Call<List<Photo>> getPhotosByUserId(@Path("userId") String userId);

    // Tag operations
    @POST("tags")
    Call<Tag> createTag(@Body Tag tag);

    @GET("tags/{id}")
    Call<Tag> getTagById(@Path("id") String id);

    @GET("tags")
    Call<List<Tag>> getAllTags();

    // PhotoTag operations
    @POST("photo_tags")
    Call<PhotoTag> createPhotoTag(@Body PhotoTag photoTag);

    @GET("photo_tags/photo/{photoId}")
    Call<List<PhotoTag>> getTagsByPhotoId(@Path("photoId") String photoId);
}
