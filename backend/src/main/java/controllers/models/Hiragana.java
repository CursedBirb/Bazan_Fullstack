package controllers.models;

import javax.persistence.*;
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
    private String hiragana_romaji;

    @Column(name = "hiragana_image")
    private String hiragana_image;

    protected Hiragana() {

    }

    public Hiragana(String hiragana_romaji, String hiragana_image) {
        this.hiragana_romaji = hiragana_romaji;
        this.hiragana_image = hiragana_image;
    }

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHiraganaRomaji() {
        return hiragana_romaji;
    }

    public void setHiraganaRomaji(String hiragana_romaji) {
        this.hiragana_romaji = hiragana_romaji;
    }

    public String getHiraganaImage() {
        return hiragana_image;
    }

    public void setHiraganaImage(String hiragana_image) {
        this.hiragana_image = hiragana_image;
    }


    @Override
    public String toString() {
        return String.format("[%s - %s - %s]", id, hiragana_romaji, hiragana_image);
    }


}