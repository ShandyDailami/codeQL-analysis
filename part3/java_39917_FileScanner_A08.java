import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39917_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Set the directory
        File directory = new File(".");

        // Use a FileScanner to recursively read files in the directory
        FileScanner fileScanner = new FileScanner(directory);

        // Process each file
        while (fileScanner.hasNext()) {
            File file = fileScanner.nextFile();
            printFileContents(file);
        }

        // Close the scanner
        fileScanner.close();
    }

    private static void printFileContents(File file) {
        System.out.println("File: " + file.getName());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}