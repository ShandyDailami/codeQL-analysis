import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05979_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Use a Scanner to get input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Use a FileScanner to scan the directory for files
        FileScanner fileScanner = new FileScanner(directory, "*.txt");

        // Use a try-with-resources statement to automatically close the scanner
        // when the FileScanner is no longer needed
        try (FileScanner scanner = fileScanner) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                System.out.println("Found file: " + file.getName());
            }
        }
    }
}