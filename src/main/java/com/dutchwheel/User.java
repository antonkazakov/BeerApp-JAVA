package com.dutchwheel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by antonkazakov on 04.12.16.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    private Integer id;

    @Column(name = "simple_name")
    private String phone;

    @Column(name = "photo_path")
    private String photoPath;

    @Column(name = "place")
    private String place;

    @Column(name = "api_key")
    private String apiKey;

    public User() {
    }

    public User(String phone, int id, String photoPath, String place) {
        this.phone = phone;
        this.id = id;
        this.photoPath = photoPath;
        this.place = place;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
