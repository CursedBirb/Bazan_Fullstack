package controllers.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "hiragana")
public class Hiragana {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "hiragana_romaji")
    private String hiraganaRomaji;

    @Column(name = "hiragana_image")
    private String hiraganaImage;

    @Column(name = "hiragana_id")
    private String hiraganaId;

    public Hiragana() {

        this.hiraganaRomaji = "brak";
        this.hiraganaImage = "brak";
        this.hiraganaId = "brak";

    }

    public Hiragana(String hiraganaRomaji, String hiraganaImage, String hiraganaId) {
        this.hiraganaRomaji = hiraganaRomaji;
        this.hiraganaImage = hiraganaImage;
        this.hiraganaId = hiraganaId;
    }

}