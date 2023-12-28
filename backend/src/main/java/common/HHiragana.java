package common;

import controllers.models.Hiragana;
import lombok.Data;

@Data
public class HHiragana {
    
    private int id;
    private String hiraganaRomaji;
    private String hiraganaImage;
    private String hiraganaId;

    
    public HHiragana(int id, String hiraganaRomaji, String hiraganaImage, String hiraganaId) {
        this.id = id;
        this.hiraganaRomaji = hiraganaRomaji;
        this.hiraganaImage = hiraganaImage;
        this.hiraganaId = hiraganaId;
    }
    
    public HHiragana(Hiragana hiragana) {
        this.id = hiragana.getId();
        this.hiraganaRomaji = hiragana.getHiraganaRomaji();
        this.hiraganaImage = hiragana.getHiraganaImage();
        this.hiraganaId = hiragana.getHiraganaId();
    }
    
    public HHiragana(String errorText) {
        this.id = -1;
        this.hiraganaRomaji = errorText;
        this.hiraganaImage = errorText;
        this.hiraganaId = errorText;
    }

    public HHiragana() {
        this.id = 0;
        this.hiraganaRomaji = "brak";
        this.hiraganaImage = "brak";
        this.hiraganaId = "brak";
    }

}
