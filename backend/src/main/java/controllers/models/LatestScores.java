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
@Table(name = "latest_scores")
public class LatestScores {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "hiragana_score_1")
    private Long hiraganaScore1;

    @Column(name = "hiragana_score_2")
    private Long hiraganaScore2;

    @Column(name = "hiragana_score_3")
    private Long hiraganaScore3;

    @Column(name = "katakana_score_1")
    private Long katakanaScore1;

    @Column(name = "katakana_score_2")
    private Long katakanaScore2;

    @Column(name = "katakana_score_3")
    private Long katakanaScore3;
    
    public LatestScores() {

        this.username = "brak";
        this.hiraganaScore1 = (long) -32.0;
        this.hiraganaScore2 = (long) -32.0;
        this.hiraganaScore3 = (long) -32.0;
        this.katakanaScore1 = (long) -32.0;
        this.katakanaScore2 = (long) -32.0;
        this.katakanaScore3 = (long) -32.0;

    }

    public LatestScores(String username, Long hiraganaScore1, Long hiraganaScore2, Long hiraganaScore3, Long katakanaScore1, Long katakanaScore2, Long katakanaScore3) {

        this.username = username;
        this.hiraganaScore1 = hiraganaScore1;
        this.hiraganaScore2 = hiraganaScore2;
        this.hiraganaScore3 = hiraganaScore3;
        this.katakanaScore1 = katakanaScore1;
        this.katakanaScore2 = katakanaScore2;
        this.katakanaScore3 = katakanaScore3;

    }

}
