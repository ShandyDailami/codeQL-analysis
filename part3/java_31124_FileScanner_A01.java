import java.io.File;
import java.util.Scanner;

public class java_31124_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner to read the file
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        try {
            // Open the file
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File does not exist!");
                System.exit(1);
            }

            // Use a scanner to read each line of the file
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                // Check if the line starts with a specific string
                if (line.startsWith("A01:")) {
                    System.out.println(line);
                }
            }

            // Close the scanner
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }
    }
}