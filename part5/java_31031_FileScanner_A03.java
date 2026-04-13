import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_31031_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("src");

        // Use a try-with-resources statement to automatically close the scanner
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }

        // Another way to use Scanner is to load the file into an array
        // This is not a recommended way for larger files due to memory usage
        // String[] lines = new Scanner(file).useDelimiter("\\W+").tokens();
    }
}