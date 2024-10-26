package com.map.rute.data.dao.impl;

import com.map.rute.data.dao.PhotoTagDAO;
import com.map.rute.data.models.PhotoTag;

import java.util.List;
import java.util.UUID;

public class PhotoTagDAOImpl implements PhotoTagDAO {
    @Override
    public PhotoTag getPhotoTagById(UUID id) {
        // Lógica para obtener una relación photo_tag por ID
        return null;
    }

    @Override
    public List<PhotoTag> getAllPhotoTags() {
        // Lógica para obtener todas las relaciones photo_tag
        return java.util.Collections.emptyList();
    }

    @Override
    public void addPhotoTag(PhotoTag photoTag) {
        // Lógica para agregar una relación photo_tag
    }

    @Override
    public void deletePhotoTag(UUID id) {
        // Lógica para eliminar una relación photo_tag
    }
}

