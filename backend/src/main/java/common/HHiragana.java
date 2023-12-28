package common;

import controllers.models.Hiragana;
import lombok.Data;

@Data
public class HHiragana {
    
    private Long id;
    private String hiraganaRomaji;
    private String hiraganaImage;

    
    public HHiragana(Long id, String hiraganaRomaji, String hiraganaImage) {
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
        this.id = (long) -1.0;
        this.hiraganaRomaji = errorText;
        this.hiraganaImage = errorText;
    }

    public HHiragana() {
        this.id = (long) 0.0;
        this.hiraganaRomaji = "brak";
        this.hiraganaImage = "brak";
    }

}
