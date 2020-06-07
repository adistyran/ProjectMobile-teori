package com.example.travelapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)

    @NonNull
    private int id;
    private String nama;
    private String namabelakang;
    private String email;
    private String password;

    public User(String nama, String namabelakang, String email, String password) {
        this.id = id;
        this.nama = nama;
        this.namabelakang = namabelakang;
        this.email = email;
        this.password = password;
    }



    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNamabelakang() {
        return namabelakang;
    }

    public void setNamabelakang(String namabelakang) {
        this.namabelakang = namabelakang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return  "User{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", namabelakang='" + namabelakang + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
