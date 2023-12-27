package controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import controllers.models.Hiragana;

public interface HiraganaRepository extends JpaRepository<Hiragana, Long> {

    public Hiragana findById(int id);
    // Dodać metody zapytań
    
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
