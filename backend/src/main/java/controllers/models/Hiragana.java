package controllers.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hiragana")
@Getter @Setter
public class Hiragana {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "hiragana_romaji")
    private String hiraganaRomaji;

    @Column(name = "hiragana_image")
    private String hiraganaImage;

    protected Hiragana() {

    }

    public Hiragana(String hiraganaRomaji, String hiraganaImage) {
        this.hiraganaRomaji = hiraganaRomaji;
        this.hiraganaImage = hiraganaImage;
    }

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHiraganaRomaji() {
        return hiraganaRomaji;
    }

    public void setHiraganaRomaji(String hiraganaRomaji) {
        this.hiraganaRomaji = hiraganaRomaji;
    }

    public String getHiraganaImage() {
        return hiraganaImage;
    }

    public void setHiraganaImage(String hiraganaImage) {
        this.hiraganaImage = hiraganaImage;
    }


    @Override
    public String toString() {
        return String.format("[%s - %s - %s]", id, hiraganaRomaji, hiraganaImage);
    }


}