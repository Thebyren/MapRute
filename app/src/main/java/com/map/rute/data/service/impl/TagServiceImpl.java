package com.map.rute.data.service.impl;

import com.map.rute.data.dao.TagDAO;
import com.map.rute.data.models.Tag;
import com.map.rute.data.service.TagService;

import java.util.List;
import java.util.UUID;

public class TagServiceImpl implements TagService {
    private TagDAO tagDAO;

    public TagServiceImpl(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    @Override
    public Tag getTagById(UUID id) {
        return tagDAO.getTagById(id);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagDAO.getAllTags();
    }

    @Override
    public void addTag(Tag tag) {
        tagDAO.addTag(tag);
    }

    @Override
    public void updateTag(Tag tag) {
        tagDAO.updateTag(tag);
    }

    @Override
    public void deleteTag(UUID id) {
        tagDAO.deleteTag(id);
    }
}

