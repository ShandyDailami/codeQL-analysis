import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25948_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a scanner to read from standard input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the directory to scan
        System.out.print("Enter the directory to scan: ");
        String dirPath = scanner.nextLine();

        // Create a File object to represent the directory
        File dir = new File(dirPath);

        // Create a FileScanner to scan the directory
        FileScanner fileScanner = dir.newFileScanner();

        // Prompt the user for the file name to search for
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.nextLine();

        // Use the FileScanner to find the file with the specified name
        File file = fileScanner.nextMatchingFile(fileName);

        // Check if the file was found
        if (file != null) {
            System.out.println("File found: " + file.getPath());
        } else {
            System.out.println("File not found");
        }
    }
}