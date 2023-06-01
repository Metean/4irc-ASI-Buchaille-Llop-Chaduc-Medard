package com.cpe.vengaboys.asi.shared.dto;

public class CardDto {
    private Long id;
    private float price;
    private String name;
    private String description;
    private String imageUrl;
    private String type1;
    private String type2;
    private int hp;
    private int attack;
    private int defense;

    public CardDto() {}

    public CardDto(float price, String name, String description, String imageUrl, String type1, String type2, int hp, int attack, int defense) {
        this.price = price;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }
}
