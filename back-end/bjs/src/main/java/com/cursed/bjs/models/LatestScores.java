package com.cursed.bjs.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LatestScores")
@Getter @Setter
public class LatestScores {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "hiragana_score_1")
    private Long hiragana_score_1;

    @Column(name = "hiragana_score_2")
    private Long hiragana_score_2;

    @Column(name = "hiragana_score_3")
    private Long hiragana_score_3;

    @Column(name = "katakana_score_1")
    private Long katakana_score_1;

    @Column(name = "katakana_score_2")
    private Long katakana_score_2;

    @Column(name = "katakana_score_3")
    private Long katakana_score_3;
    
    protected LatestScores() {

    }

    public LatestScores(String username, Long hiragana_score_1, Long hiragana_score_2, Long hiragana_score_3, Long katakana_score_1, Long katakana_score_2, Long katakana_score_3) {

        this.username = username;
        this.hiragana_score_1 = hiragana_score_1;
        this.hiragana_score_2 = hiragana_score_2;
        this.hiragana_score_3 = hiragana_score_3;
        this.katakana_score_1 = katakana_score_1;
        this.katakana_score_2 = katakana_score_2;
        this.katakana_score_3 = katakana_score_3;

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
        return hiragana_score_1;
    }

    public void setHiraganaScore1(Long hiragana_score_1) {
        this.hiragana_score_1 = hiragana_score_1;
    }

    public Long getHiraganaScore2() {
        return hiragana_score_2;
    }

    public void setHiraganaScore2(Long hiragana_score_2) {
        this.hiragana_score_2 = hiragana_score_2;
    }

    public Long getHiraganaScore3() {
        return hiragana_score_3;
    }

    public void setHiraganaScore3(Long hiragana_score_3) {
        this.hiragana_score_3 = hiragana_score_3;
    }

    public Long getKatakanaScore1() {
        return katakana_score_1;
    }

    public void setKatakanaScore1(Long katakana_score_1) {
        this.katakana_score_1 = katakana_score_1;
    }

    public Long getKatakanaScore2() {
        return katakana_score_2;
    }

    public void setKatakanaScore2(Long katakana_score_2) {
        this.katakana_score_2 = katakana_score_2;
    }

    public Long getKatakanaScore3() {
        return katakana_score_3;
    }

    public void setKatakanaScore3(Long katakana_score_3) {
        this.katakana_score_3 = katakana_score_3;
    }

    @Override
    public String toString() {
        return String.format("[%s - %s - %s - %s - %s - %s - %s - %s]", id, username, hiragana_score_1, hiragana_score_2, hiragana_score_3, katakana_score_1, katakana_score_2, katakana_score_3);
    }

}
