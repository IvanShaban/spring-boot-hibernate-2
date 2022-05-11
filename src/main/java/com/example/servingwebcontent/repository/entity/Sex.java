package com.example.servingwebcontent.repository.entity;

public enum Sex {
    MALE("мужской"),
    FEMALE("женский");

    private final String translation;

    Sex(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
