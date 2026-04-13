import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17130_FileScanner_A03 {

    public static void main(String[] args) {

        // Get the filename from command line arguments
        String filename = args[0];

        // Create a File object
        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {
            // Use a while loop to read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}