import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23487_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // create a new File object
        File file = new File(".");

        // use a try-with-resources statement to automatically close the scanner when we're done
        try (Scanner scanner = new Scanner(file)) {
            // use a while loop to read all the lines
            while (scanner.hasNextLine()) {
                // read the next line and print it
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }
}