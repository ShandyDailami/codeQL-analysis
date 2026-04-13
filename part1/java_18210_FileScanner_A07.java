import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18210_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        // Get all files in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    // Open the file and read it
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }

        // Close the scanner
        scanner.close();
    }
}