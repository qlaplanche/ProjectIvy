
package example;

import org.apache.commons.lang.WordUtils;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.*;

public class Hello {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String message = "hello ivy !";
        System.out.println("standard message : " + message);
        System.out.println("capitalized by " + WordUtils.class.getName() + " : " + WordUtils.capitalizeFully(message));

        try {
            int maximum = 0;
            CSVReader reader = new CSVReader(new FileReader("data.csv"));
            List<String[]> myEntries = reader.readAll();

            for (String[] entry : myEntries) {
                for (int i = 0; i < entry.length; i++) {
                    int numData = Integer.parseInt(entry[i]);
                    if (numData > maximum)
                        maximum = numData;
                    System.out.println("Nombre lu : " + numData);
                }
            }
            System.out.println("Max : " + maximum);
        } catch (IOException exception) {
            System.err.println("Error reading the csv" + exception);
        }
    }
}
