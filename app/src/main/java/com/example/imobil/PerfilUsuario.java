package com.example.imobil;

import java.util.List;

public class PerfilUsuario {
    private String name;
    private String email;
    private String profilePictureUrl;
    private String savedCard;
    private List<String> institutions;

    // Construtores, getters e setters
    public PerfilUsuario(String name, String email, String profilePictureUrl, String savedCard, List<String> institutions) {
        this.name = name;
        this.email = email;
        this.profilePictureUrl = profilePictureUrl;
        this.savedCard = savedCard;
        this.institutions = institutions;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public String getSavedCard() {
        return savedCard;
    }

    public List<String> getInstitutions() {
        return institutions;
    }
}
