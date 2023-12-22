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
@Table(name = "latest_scores")
@Getter @Setter
public class LatestScores {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

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
    
    protected LatestScores() {

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

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getHiraganaScore1() {
        return hiraganaScore1;
    }

    public void setHiraganaScore1(Long hiraganaScore1) {
        this.hiraganaScore1 = hiraganaScore1;
    }

    public Long getHiraganaScore2() {
        return hiraganaScore2;
    }

    public void setHiraganaScore2(Long hiraganaScore2) {
        this.hiraganaScore2 = hiraganaScore2;
    }

    public Long getHiraganaScore3() {
        return hiraganaScore3;
    }

    public void setHiraganaScore3(Long hiraganaScore3) {
        this.hiraganaScore3 = hiraganaScore3;
    }

    public Long getKatakanaScore1() {
        return katakanaScore1;
    }

    public void setKatakanaScore1(Long katakanaScore1) {
        this.katakanaScore1 = katakanaScore1;
    }

    public Long getKatakanaScore2() {
        return katakanaScore2;
    }

    public void setKatakanaScore2(Long katakanaScore2) {
        this.katakanaScore2 = katakanaScore2;
    }

    public Long getKatakanaScore3() {
        return katakanaScore3;
    }

    public void setKatakanaScore3(Long katakanaScore3) {
        this.katakanaScore3 = katakanaScore3;
    }

    @Override
    public String toString() {
        return String.format("[%s - %s - %s - %s - %s - %s - %s - %s]", id, username, hiraganaScore1, hiraganaScore2, hiraganaScore3, katakanaScore1, katakanaScore2, katakanaScore3);
    }

}
