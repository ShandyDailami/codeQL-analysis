import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_30281_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a new File object
        File file = new File("test.txt");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        // Check if the file is empty
        if (file.length() == 0) {
            System.out.println("File is empty!");
            return;
       
        }

        try (Scanner scanner = new Scanner(file)) {
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}