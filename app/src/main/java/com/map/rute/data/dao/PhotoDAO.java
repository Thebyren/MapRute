package com.map.rute.data.dao;

import com.map.rute.data.models.Photo;

import java.util.List;
import java.util.UUID;

public interface PhotoDAO {
    Photo getPhotoById(UUID id);
    List<Photo> getAllPhotos();
    void addPhoto(Photo photo);
    void updatePhoto(Photo photo);
    void deletePhoto(UUID id);
}

