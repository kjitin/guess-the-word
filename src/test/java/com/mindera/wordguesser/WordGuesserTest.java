package com.mindera.wordguesser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class WordGuesserTest {

  private WordGuesser wordGuesser;

  @Before
  public void setUp() throws Exception {
    wordGuesser = new WordGuesser();
  }

  @Test
  public void pickWrongLetterShowsWord() {
    String word = wordGuesser.pickLetter('a');
    Assert.assertThat(word, is(getWord(word.length())));
  }

  @Test
  public void pickOneCorrectLetterShowsWord() {
    String word = wordGuesser.pickLetter('k');
    Assert.assertThat(word, containsString("k"));
  }

  @Test
  public void pickTwoCorrectLetterShowsWord() {
    String word = wordGuesser.pickLetter('o');
    Assert.assertThat(word, containsString("oo"));
  }

  @Test
  public void correctWordIsShown() {
    wordGuesser.pickLetter('o');
    wordGuesser.pickLetter('k');
    String thirdAttempt = wordGuesser.pickLetter('b');
    Assert.assertThat(thirdAttempt, anyOf(is("book"), is("*ook"), is("**ook")));
  }

  private String getWord(int length) {
    StringBuilder word = new StringBuilder();
    for (int i = 0; i < length; i++) {
      word.append("*");
    }
    return word.toString();
  }

}
