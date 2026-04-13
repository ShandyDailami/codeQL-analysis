import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_08011_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a new File object for the text file
        File file = new File("path_to_your_file.txt");
        
        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            // Use a while loop to read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}