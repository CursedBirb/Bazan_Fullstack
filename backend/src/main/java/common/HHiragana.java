package common;

import controllers.models.Hiragana;
import lombok.Data;

@Data
public class HHiragana {
    
    private int id;
    private String hiraganaRomaji;
    private String hiraganaImage;

    
    public HHiragana(int id, String hiraganaRomaji, String hiraganaImage) {
        this.id = id;
        this.hiraganaRomaji = hiraganaRomaji;
        this.hiraganaImage = hiraganaImage;
    }
    
    public HHiragana(Hiragana hiragana) {
        this.id = hiragana.getId();
        this.hiraganaRomaji = hiragana.getHiraganaRomaji();
        this.hiraganaImage = hiragana.getHiraganaImage();
    }
    
    public HHiragana(String errorText) {
        this.id = -1;
        this.hiraganaRomaji = errorText;
        this.hiraganaImage = errorText;
    }

    public HHiragana() {
        this.id = 0;
        this.hiraganaRomaji = "brak";
        this.hiraganaImage = "brak";
    }

}
