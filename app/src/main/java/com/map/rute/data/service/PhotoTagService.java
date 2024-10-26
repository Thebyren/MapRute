package com.map.rute.data.service;

import com.map.rute.data.models.PhotoTag;

import java.util.List;
import java.util.UUID;

public interface PhotoTagService {
    PhotoTag getPhotoTagById(UUID id);
    List<PhotoTag> getAllPhotoTags();
    void addPhotoTag(PhotoTag photoTag);
    void deletePhotoTag(UUID id);
}

