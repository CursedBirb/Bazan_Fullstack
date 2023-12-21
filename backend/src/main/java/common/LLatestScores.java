package common;

import controllers.models.LatestScores;
import lombok.Data;

@Data //Adnotacja @Data wystarczy aby Lombok wygenerował getery, setery, toString, equals i inne 
public class LLatestScores {
        
    private Long id;
    private String username;
    private Long hiragana_score_1;    
    private Long hiragana_score_2;
    private Long hiragana_score_3;
    private Long katakana_score_1;
    private Long katakana_score_2;
    private Long katakana_score_3;
    

    public LLatestScores(Long id, String username, Long hiragana_score_1, Long hiragana_score_2, Long hiragana_score_3, Long katakana_score_1, Long katakana_score_2, Long katakana_score_3) {    
        this.id = id;
        this.username = username;
        this.hiragana_score_1 = hiragana_score_1;
        this.hiragana_score_2 = hiragana_score_2;
        this.hiragana_score_3 = hiragana_score_3;
        this.katakana_score_1 = katakana_score_1;
        this.katakana_score_2 = katakana_score_2;
        this.katakana_score_3 = katakana_score_3;
    }
    
    public LLatestScores(LatestScores latesScores) {        
        this.id = latesScores.getId();
        this.username = latesScores.getUsername();
        this.hiragana_score_1 = latesScores.getHiraganaScore1();
        this.hiragana_score_2 = latesScores.getHiraganaScore2();
        this.hiragana_score_3 = latesScores.getHiraganaScore3();
        this.katakana_score_1 = latesScores.getKatakanaScore1();
        this.katakana_score_2 = latesScores.getKatakanaScore2();
        this.katakana_score_3 = latesScores.getKatakanaScore3();
    }
    
    public LLatestScores(String errorText) {        
        this.id = (long) -1.0;
        this.username = errorText;
        this.hiragana_score_1 = (long) 0.0;
        this.hiragana_score_2 = (long) 0.0;
        this.hiragana_score_3 = (long) 0.0;
        this.katakana_score_1 = (long) 0.0;
        this.katakana_score_2 = (long) 0.0;
        this.katakana_score_3 = (long) 0.0;
    }

    public LLatestScores() {               
        this.id = (long) -1;
        this.username = "brak";
        this.hiragana_score_1 = (long) 0;
        this.hiragana_score_2 = (long) 0;
        this.hiragana_score_3 = (long) 0;
        this.katakana_score_1 = (long) 0;
        this.katakana_score_2 = (long) 0;
        this.katakana_score_3 = (long) 0;
    }
    
}
