package com.map.rute.data.dao.impl;

import com.map.rute.data.dao.PhotoDAO;
import com.map.rute.data.db.SQLiteConnection;
import com.map.rute.data.models.Photo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class PhotoDAOImpl implements PhotoDAO {
    @Override
    public Photo getPhotoById(UUID id) {
        // Lógica para obtener una foto por ID
    }

    @Override
    public List<Photo> getAllPhotos() {
        // Lógica para obtener todas las fotos
    }

    @Override
    public void addPhoto(Photo photo) {
        String sql = "INSERT INTO photos(id, user_id, photo_url, latitude, longitude, location_name, created_at) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLiteConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, photo.getId().toString());
            pstmt.setString(2, photo.getUserId().toString());
            pstmt.setString(3, photo.getPhotoUrl());
            pstmt.setDouble(4, photo.getLatitude());
            pstmt.setDouble(5, photo.getLongitude());
            pstmt.setString(6, photo.getLocationName());
            pstmt.setDate(7, java.sql.Date.valueOf(photo.getCreatedAt()));
            pstmt.executeUpdate();

            System.out.println("Foto agregada a SQLite.");
        } catch (SQLException e) {
            System.out.println("Error al agregar foto: " + e.getMessage());
        }
    }

    @Override
    public void updatePhoto(Photo photo) {
        // Lógica para actualizar una foto
    }

    @Override
    public void deletePhoto(UUID id) {
        // Lógica para eliminar una foto
    }
}

