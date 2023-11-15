package com.cursed.bjs.database;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity 
@Getter @Setter @ToString
@NoArgsConstructor
@Table(name = "hiragana")
public class Hiragana {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)

  private Integer id;
  private String hiragana_romaji;
  private String hiragana_image;

  public Hiragana(String hiragana_romaji, String hiragana_image) {
    this.hiragana_romaji = hiragana_romaji;
    this.hiragana_image = hiragana_image;
  }


}