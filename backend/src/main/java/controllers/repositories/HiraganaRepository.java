package controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import controllers.models.Hiragana;

@Repository
public interface HiraganaRepository extends JpaRepository<Hiragana, Integer> {

    public Hiragana findById(int id);
    public Hiragana findByHiraganaRomaji(String hiraganaRomaji);
    // Dodać metody zapytań

    //public Hiragana get(int i);
    
    //List<sHiragana> findByHiragana_romaji(String hiragana_romaji);


    //LISTA OPERATOROW DO TWORZENIA ZAPYTAN
/*
IsAfter, After, IsGreaterThan, GreaterThan;
IsGreaterThanEqual, GreaterThanEqual;
IsBefore, Before, IsLessThan, LessThan;
IsLessThanEqual, LessThanEqual;
IsBetween, Between;
IsNull, Null;
IsNotNull, NotNull;
IsIn, In;
IsNotIn, NotIn;
IsStartingWith, StartingWith, StartsWith;
IsEndingWith, EndingWith, EndsWith;
IsContaining, Containing, Contains;
IsLike, Like;
IsNotLike, NotLike;
IsTrue, True;
IsFalse, False;
Is, Equals;
IsNot, Not;
And, Or
OrderBy
*/
}
