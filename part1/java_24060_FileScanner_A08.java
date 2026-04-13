import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24060_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/A08_IntegrityFailure.txt"); // Create File object
        Scanner fileScanner = new Scanner(file); // Create Scanner object to read the file

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

        fileScanner.close(); // Close Scanner object
    }
}