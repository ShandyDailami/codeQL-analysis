import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34924_FileScanner_A08 {

    public static void main(String[] args) {
        // Get the directory from user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directoryPath = scanner.nextLine();

        // Get the file name from user input
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        // Create a File object
        File directory = new File(directoryPath);

        // List all files in the directory
        File[] listOfFiles = directory.listFiles();

        // Search for the file
        boolean fileFound = false;
        for (File file : listOfFiles) {
            if (file.getName().equals(fileName)) {
                fileFound = true;
                break;
            }
        }

        if (fileFound) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }

        scanner.close();
    }
}