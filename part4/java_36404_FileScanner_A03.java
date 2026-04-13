import java.io.File;
import java.util.Scanner;

public class java_36404_FileScanner_A03 {

    public static void main(String[] args) {

        // Step 1: Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        // Step 2: Create a File object for the directory
        File directory = new File(directoryPath);

        // Step 3: Create a File object for the file we want to read
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
        File file = new File(directory, fileName);

        // Step 4: Create a FileScanner to read the file
        try {
            java.io.FileScanner fileScanner = new java.io.FileScanner(file);
            fileScanner.useDelimiter();

            // Step 5: Use the FileScanner to print the contents of the file
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

            fileScanner.close();

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}