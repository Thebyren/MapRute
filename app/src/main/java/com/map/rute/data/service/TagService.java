package com.map.rute.data.service;

import com.map.rute.data.models.Tag;

import java.util.List;
import java.util.UUID;

public interface TagService {
    Tag getTagById(UUID id);
    List<Tag> getAllTags();
    void addTag(Tag tag);
    void updateTag(Tag tag);
    void deleteTag(UUID id);
}

