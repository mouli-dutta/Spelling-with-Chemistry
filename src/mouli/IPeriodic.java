package mouli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// interface used to initialise
// the Periodic table elements
public interface IPeriodic {

    static List<Elements> initTable() {
        // list to store chemistry elements
        final List<Elements> chem = new ArrayList<>();

        try (var reader = new BufferedReader(
                new InputStreamReader(
                        // periodic table url
                        new URL("https://run.mocky.io/v3/fc7a8b82-5503-4919-8c98-5a6069a218f9")
                                .openStream()
                ))) {

            // reading all lines from url
            reader.lines().forEach(line ->
                    Arrays.stream(line.split(";"))
                    .forEach(s -> {
                        String[] c = s.split(",");

                        // adding elements to list
                        chem.add(new Elements(
                                c[0], c[1], c[2], c[3],
                                c[4], c[5], c[6], c[7]));
                    })
            );

        } catch (IOException ignored) {
        }

        return chem;
    }
}
