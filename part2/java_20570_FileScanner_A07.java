import java.io.File;
import java.util.Scanner;

public class java_20570_FileScanner_A07 {

    public static void main(String[] args) {

        // Create a Scanner object to read command line arguments
        Scanner scanner = new Scanner(System.in);

        // Ask user for directory path
        System.out.println("Please enter the directory path: ");
        String directoryPath = scanner.nextLine();

        // Ask user for search string
        System.out.println("Please enter the search string: ");
        String searchString = scanner.nextLine();

        // Use File.listFiles method to get list of files in a directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // If the directory doesn't exist, print error message and exit
        if (files == null) {
            System.out.println("The directory does not exist.");
            System.exit(1);
        }

        // Scan each file
        for (File file : files) {
            if (file.isFile()) {
                // If the file is a text file, check for the search string
                if (file.getName().endsWith(".txt")) {
                    StringBuilder content = new StringBuilder();
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            content.append(fileScanner.nextLine());
                        }

                        if (content.toString().contains(searchString)) {
                            System.out.println("Found the string: " + searchString + " in file: " + file.getName());
                        }
                    }
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}