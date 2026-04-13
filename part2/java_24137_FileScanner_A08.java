import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24137_FileScanner_A08 {

    private static final String INPUT_FILE = "input.txt";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(INPUT_FILE));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // You could also use a library like Apache Commons IO for more complex file I/O operations.
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file " + INPUT_FILE + " could not be found!");
        }
    }
}