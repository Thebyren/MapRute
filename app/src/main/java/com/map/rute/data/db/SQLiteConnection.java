package com.map.rute.data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {
    private static final String DB_URL = "jdbc:sqlite:your_database_name.db";
    private static Connection conn = null;

    // Método para obtener la conexión
    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(DB_URL);
                System.out.println("Conexión a SQLite establecida.");
            } catch (SQLException e) {
                System.out.println("Error al conectar con SQLite: " + e.getMessage());
            }
        }
        return conn;
    }

    // Método para cerrar la conexión
    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexión a SQLite cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // Método para crear las tablas si no existen
    public static void createTables() {
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users (id TEXT PRIMARY KEY,name TEXT,email TEXT,password_hash TEXT,created_at TIMESTAMP);";
        String createPhotosTable = "CREATE TABLE IF NOT EXISTS photos (id TEXT PRIMARY KEY,user_id TEXT,photo_url TEXT,latitude REAL,longitude REAL,location_name TEXT,created_at DATE,FOREIGN KEY (user_id) REFERENCES users(id));";
        String createTagsTable = "CREATE TABLE IF NOT EXISTS tags ( id TEXT PRIMARY KEY, name TEXT);";
        String createPhotoTagsTable = "CREATE TABLE IF NOT EXISTS photo_tags ( id TEXT PRIMARY KEY,photo_id TEXT, tag_id TEXT,FOREIGN KEY (photo_id) REFERENCES photos(id),FOREIGN KEY (tag_id) REFERENCES tags(id));";
        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createPhotosTable);
            stmt.execute(createTagsTable);
            stmt.execute(createPhotoTagsTable);
            System.out.println("Tablas creadas o verificadas en SQLite.");
        } catch (SQLException e) {
            System.out.println("Error al crear las tablas: " + e.getMessage());
        }
    }
}
