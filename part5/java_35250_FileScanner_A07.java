import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_35250_FileScanner_A07 {

    public static void main(String[] args) {
        // Create a new File object to represent the directory of the current file
        File directory = new File(".");

        // Use the listFiles() method of the File class to get a list of all files and directories in the current directory
        File[] listOfFiles = directory.listFiles();

        // Use a Scanner to read the file content line by line
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }

        // Security-sensitive operation: directory listing
        listDirectoryContent();

        // Security-sensitive operation: accessing a nonexistent file
        try {
            File nonexistentFile = new File("nonexistent.txt");
            System.out.println("Size of " + nonexistentFile.getName() + ": " + nonexistentFile.length());
        } catch (Exception e) {
            System.out.println("Error accessing the file: " + e.getMessage());
        }
    }

    // Security-sensitive operation: directory listing
    private static void listDirectoryContent() {
        try {
            File[] listOfFiles = new File(".").listFiles();
            if (listOfFiles != null) {
                Arrays.stream(listOfFiles).forEach(file -> System.out.println(file.getName()));
            }
        } catch (Exception e) {
            System.out.println("Error listing the directory content: " + e.getMessage());
        }
    }
}