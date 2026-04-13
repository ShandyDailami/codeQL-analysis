import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07315_FileScanner_A08 {
    public static void main(String[] args) {
        // Remove the comment by following this line
        File file = new File("A08_IntegrityFailure.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}