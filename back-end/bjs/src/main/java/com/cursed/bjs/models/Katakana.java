package com.cursed.bjs.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "katakana")
@Getter @Setter
public class Katakana {
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "katakana_romaji")
    private String katakana_romaji;

    @Column(name = "katakana_image")
    private String katakana_image;

    protected Katakana() {

    }

    public Katakana(String katakana_romaji, String katakana_image) {
        this.katakana_romaji = katakana_romaji;
        this.katakana_image = katakana_image;
    }

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKatakanaRomaji() {
        return katakana_romaji;
    }

    public void setKatakanaRomaji(String katakana_romaji) {
        this.katakana_romaji = katakana_romaji;
    }

    public String getKatakanaImage() {
        return katakana_image;
    }

    public void setKatakanaImage(String katakana_image) {
        this.katakana_image = katakana_image;
    }


    @Override
    public String toString() {
        return String.format("[%s - %s - %s]", id, katakana_romaji, katakana_image);
    }

}
