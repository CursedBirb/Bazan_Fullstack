package common;

import controllers.models.LatestScores;
import lombok.Data;

@Data //Adnotacja @Data wystarczy aby Lombok wygenerował getery, setery, toString, equals i inne
public class LLatestScores {
        
    private int id;
    private String username;
    private Long hiraganaScore1;
    private Long hiraganaScore2;
    private Long hiraganaScore3;
    private Long katakanaScore1;
    private Long katakanaScore2;
    private Long katakanaScore3;
    
    public LLatestScores(int id, String username, Long hiraganaScore1, Long hiraganaScore2, Long hiraganaScore3, Long katakanaScore1, Long katakanaScore2, Long katakanaScore3) {
        this.id = id;
        this.username = username;
        this.hiraganaScore1 = hiraganaScore1;
        this.hiraganaScore2 = hiraganaScore2;
        this.hiraganaScore3 = hiraganaScore3;
        this.katakanaScore1 = katakanaScore1;
        this.katakanaScore2 = katakanaScore2;
        this.katakanaScore3 = katakanaScore3;
    }
    
    public LLatestScores(LatestScores latesScores) {
        this.id = latesScores.getId();
        this.username = latesScores.getUsername();
        this.hiraganaScore1 = latesScores.getHiraganaScore1();
        this.hiraganaScore2 = latesScores.getHiraganaScore2();
        this.hiraganaScore3 = latesScores.getHiraganaScore3();
        this.katakanaScore1 = latesScores.getKatakanaScore1();
        this.katakanaScore2 = latesScores.getKatakanaScore2();
        this.katakanaScore3 = latesScores.getKatakanaScore3();
    }
    
    public LLatestScores(String errorText) {
        this.id = -1;
        this.username = errorText;
        this.hiraganaScore1 = (long) 0.0;
        this.hiraganaScore2 = (long) 0.0;
        this.hiraganaScore3 = (long) 0.0;
        this.katakanaScore1 = (long) 0.0;
        this.katakanaScore2 = (long) 0.0;
        this.katakanaScore3 = (long) 0.0;
    }

    public LLatestScores() {
        this.id = -1;
        this.username = "brak";
        this.hiraganaScore1 = (long) -32;
        this.hiraganaScore2 = (long) -32;
        this.hiraganaScore3 = (long) -32;
        this.katakanaScore1 = (long) -32;
        this.katakanaScore2 = (long) -32;
        this.katakanaScore3 = (long) -32;
    }
    
    
}
