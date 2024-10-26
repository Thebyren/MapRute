package com.map.rute.data.dao.impl;

import com.map.rute.data.dao.TagDAO;
import com.map.rute.data.models.Tag;

import java.util.List;
import java.util.UUID;

public class TagDAOImpl implements TagDAO {
    @Override
    public Tag getTagById(UUID id) {
        // Lógica para obtener un tag por ID
    }

    @Override
    public List<Tag> getAllTags() {
        // Lógica para obtener todos los tags
    }

    @Override
    public void addTag(Tag tag) {
        // Lógica para agregar un tag
    }

    @Override
    public void updateTag(Tag tag) {
        // Lógica para actualizar un tag
    }

    @Override
    public void deleteTag(UUID id) {
        // Lógica para eliminar un tag
    }
}
