import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22353_FileScanner_A08 {

    public static void main(String[] args) {
        // Create a File object using the constructor
        File file = new File("src/main/resources/A08_IntegrityFailure.txt");

        try (Scanner scanner = new Scanner(file)) {
            // Use FileScanner to traverse through the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}