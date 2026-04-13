import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16161_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object for the directory
        File directory = new File(".");

        // Use a try-with-resources statement to automatically close the scanner when done
        try (Scanner scanner = new Scanner(directory.listFiles())) {
            // List all files in the directory
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                System.out.println("Scanning file: " + fileName);

                // Create a File object for the file
                File file = new File(fileName);

                // Use a try-with-resources statement to automatically close the scanner when done
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println("Scanning line: " + line);

                        // Remove comment lines with a try-with-resources statement
                        try (Scanner lineScanner = new Scanner(line)) {
                            while (lineScanner.hasNextLine()) {
                                String comment = lineScanner.nextLine();
                                System.out.println("Comment: " + comment);
                            }
                        }

                        // Remove empty lines with a try-with-resources statement
                        try (Scanner lineScanner = new Scanner(line)) {
                            while (lineScanner.hasNextLine()) {
                                String lineWithoutComment = lineScanner.nextLine();
                                System.out.println("No Comment: " + lineWithoutComment);
                           
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}