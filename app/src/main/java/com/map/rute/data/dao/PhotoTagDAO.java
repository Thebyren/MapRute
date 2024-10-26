package com.map.rute.data.dao;

import com.map.rute.data.models.PhotoTag;

import java.util.List;
import java.util.UUID;

public interface PhotoTagDAO {
    PhotoTag getPhotoTagById(UUID id);
    List<PhotoTag> getAllPhotoTags();
    void addPhotoTag(PhotoTag photoTag);
    void deletePhotoTag(UUID id);
}

