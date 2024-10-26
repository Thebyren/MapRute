package com.map.rute.data.service.impl;

import com.map.rute.data.models.Photo;
import com.map.rute.data.dao.PhotoDAO;
import com.map.rute.data.service.PhotoService;

import java.util.List;
import java.util.UUID;

public class PhotoServiceImpl implements PhotoService {
    private PhotoDAO photoDAO;

    public PhotoServiceImpl(PhotoDAO photoDAO) {
        this.photoDAO = photoDAO;
    }

    @Override
    public Photo getPhotoById(UUID id) {
        return photoDAO.getPhotoById(id);
    }

    @Override
    public List<Photo> getAllPhotos() {
        return photoDAO.getAllPhotos();
    }

    @Override
    public void addPhoto(Photo photo) {
        photoDAO.addPhoto(photo);
    }

    @Override
    public void updatePhoto(Photo photo) {
        photoDAO.updatePhoto(photo);
    }

    @Override
    public void deletePhoto(UUID id) {
        photoDAO.deletePhoto(id);
    }
}

