package mouli;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// class responsible for spelling
// given word with chemistry elements
public class ChemSpeller {
    private final String word;

    public ChemSpeller(String word) {
        this.word = word;
    }

    // initialise periodic table
    private final List<Elements> TABLE = IPeriodic.initTable();

    // set to store result elements
    private final Set<String> elem = new LinkedHashSet<>();


    // this method prints all result
    public void spellWithElements() {

        System.out.println("Spelling <" + word + ">\n");

        helper(word, "");

        if (elem.isEmpty()) {
            System.out.println("Word can not be spelled with Periodic Table elements.");
            System.exit(0);
        }

        System.out.print("\nDetails of the Elements used to spell out <" + word + ">\n");

        // print the elements details.
        elem.stream()
                .map(this::getTableElementInfo)
                .forEach(System.out::println);

    }

    // recursive helper method to spell with chem
    private void helper(final String word, final String symbols) {

        // get only symbols from the periodic table
        final List<String> SYMBOL_TABLE = TABLE.stream()
                .map(Elements::getSymbol)
                .collect(Collectors.toList());


        // used to store result
        StringBuilder sb = new StringBuilder();


        // when word length is 0 append symbols
        if (word.length() == 0) {
            sb.append(symbols.replaceFirst("-", ""));


            // else continue checking all segments
            // of length 1, 2 & 3
        } else {

            IntStream.range(1, 3)
                    .filter(len -> word.length() - len >= 0)
                    .mapToObj(n ->
                            word.substring(0, 1).toUpperCase()
                            + word.substring(1, n)
                    )
                    .filter(SYMBOL_TABLE::contains)
                    .forEach(s ->
                            helper(word.substring(s.length()),
                                    "%s-%s".formatted(symbols, s)));

        }


        // if found
        if (sb.length() != 0) {
            System.out.println(sb);

            //adding unique elements to list to show details
            elem.addAll(Arrays.asList(
                    sb.toString().split("-")));
        }
    }

    //gets the remaining details based on chem symbol
    private String getTableElementInfo(final String symbol) {

        return TABLE.stream()
                .filter(e -> e.getSymbol().equals(symbol))
                .map(new StringBuilder()::append)
                .collect(Collectors.joining());
    }
}
