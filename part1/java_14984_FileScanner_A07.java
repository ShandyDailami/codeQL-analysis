import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14984_FileScanner_A07 {

    public static void main(String[] args) {
        // Create a File object to represent the file we want to scan.
        File file = new File("src/main/resources/authfailure.txt");

        // Create a Scanner object to read the file.
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}