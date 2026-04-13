import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33503_FileScanner_A03 {
    public static void main(String[] args) {
        // Check if a file name is provided
        if (args.length == 0) {
            System.out.println("No file name provided");
            return;
        }

        // Construct a File object
        File file = new File(args[0]);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

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