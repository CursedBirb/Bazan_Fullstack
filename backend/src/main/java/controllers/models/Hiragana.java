package controllers.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "hiragana")
public class Hiragana {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "hiragana_romaji")
    private String hiraganaRomaji;

    @Column(name = "hiragana_image")
    private String hiraganaImage;

    public Hiragana() {

        this.id = 0;
        this.hiraganaRomaji = "brak";
        this.hiraganaImage = "brak";

    }

    public Hiragana(int id,String hiraganaRomaji, String hiraganaImage) {
        this.id = id;
        this.hiraganaRomaji = hiraganaRomaji;
        this.hiraganaImage = hiraganaImage;
    }

}