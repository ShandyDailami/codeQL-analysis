import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class java_21283_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File object for the file we want to read
        File file = new File("exampleFile.txt");

        // Create a Scanner object to read the file
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            // Read each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}