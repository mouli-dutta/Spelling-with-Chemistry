package mouli;

import java.util.Scanner;
/*
  This code uses Chemical elements to spell words.
    If your word can't be spelled then it
    returns "word can not be spelled"
  You can also add a single chem element
    symbol [ex: Be] to see some of it's properties.

  I used this website Mocky.io
  link -> https://designer.mocky.io/
  to create my periodic table mock api.


  Input format: Enter a word
                 (Ex: chocolate or Bees)
                Or, nothing for default.

  @author Mouli
*/


// main class of the program
public class Main {

    public static void main(String[] args) {
        String input;
        // error handling
        try (var sc = new Scanner(System.in)) {
            input = sc.next();

        } catch (Exception e) {
            input = "accessibilities";

        }

        new ChemSpeller(input).spellWithElements();

    }
}

