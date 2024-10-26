package com.map.rute.data.service.impl;

import com.map.rute.data.dao.PhotoTagDAO;
import com.map.rute.data.models.PhotoTag;
import com.map.rute.data.service.PhotoTagService;

import java.util.List;
import java.util.UUID;

public class PhotoTagServiceImpl implements PhotoTagService {
    private final PhotoTagDAO photoTagDAO;

    public PhotoTagServiceImpl(PhotoTagDAO photoTagDAO) {
        this.photoTagDAO = photoTagDAO;
    }

    @Override
    public PhotoTag getPhotoTagById(UUID id) {
        return photoTagDAO.getPhotoTagById(id);
    }

    @Override
    public List<PhotoTag> getAllPhotoTags() {
        return photoTagDAO.getAllPhotoTags();
    }

    @Override
    public void addPhotoTag(PhotoTag photoTag) {
        photoTagDAO.addPhotoTag(photoTag);
    }

    @Override
    public void deletePhotoTag(UUID id) {
        photoTagDAO.deletePhotoTag(id);
    }
}
