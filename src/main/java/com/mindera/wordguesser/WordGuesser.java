package com.mindera.wordguesser;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordGuesser {
  List<String> words = Arrays.asList("book", "nook", "crook");
  String selectedWord;

  StringBuilder maskedWord;
  WordGuesser() {
    Random random = new Random();
    selectedWord = words.get(random.nextInt(words.size()));
    maskedWord = displayMaskedWord(selectedWord);
  }

  public static StringBuilder displayMaskedWord(String selectedWord) {
    StringBuilder maskedWord = new StringBuilder();
    for (int i = 0; i < selectedWord.length(); i++) {
      maskedWord.append("*");
    }
    return maskedWord;
  }

  public String pickLetter(char enteredLetter) {
    if(selectedWord.indexOf(String.valueOf(enteredLetter))> 0) {
      int index = selectedWord.indexOf(enteredLetter);
      while (index >=0) {
        maskedWord.setCharAt(index, enteredLetter);
        index = selectedWord.indexOf(enteredLetter, index+1);
      }
    }
    return maskedWord.toString();
  }

}
