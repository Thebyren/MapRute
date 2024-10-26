package com.map.rute.data.dao;

import com.map.rute.data.models.Tag;

import java.util.List;
import java.util.UUID;

public interface TagDAO {
    Tag getTagById(UUID id);
    List<Tag> getAllTags();
    void addTag(Tag tag);
    void updateTag(Tag tag);
    void deleteTag(UUID id);
}

