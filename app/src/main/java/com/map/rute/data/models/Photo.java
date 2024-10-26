package com.map.rute.data.models;

import android.os.Build;

import java.time.LocalDate;
import java.util.UUID;

public class Photo {
    private UUID id;
    private UUID userId;
    private String photoUrl;
    private double latitude;
    private double longitude;
    private String locationName;
    private LocalDate createdAt;

    public Photo(UUID userId, double latitude, double longitude, String locationName) {
        this.userId = userId;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.createdAt = LocalDate.now();
        }
        this.id = UUID.randomUUID();
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationName = locationName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    // Constructor, Getters y Setters
}
