import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13343_FileScanner_A01 {

    public static void main(String[] args) {
        // Prompt user for file path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        try {
            File file = new File(filePath);
            if (file.exists()) {
                // Create a FileScanner to read the file
                FileScanner fileScanner = new FileScanner(file);

                // Read the file line by line
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();

                    // Perform security-sensitive operations related to A01_BrokenAccessControl
                    // For simplicity, we just print out the line
                    System.out.println(line);
                }
                fileScanner.close();
            } else {
                System.out.println("File not found!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}