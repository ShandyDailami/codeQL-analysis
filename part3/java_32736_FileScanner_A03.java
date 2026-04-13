import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32736_FileScanner_A03 {
    public static void main(String[] args) {
        // Step 1: Ask user for a directory to scan
        System.out.println("Please enter the directory to scan:");
        Scanner scanner = new Scanner(System.in);
        String directory = scanner.nextLine();

        // Step 2: Create a File object
        File file = new File(directory);

        // Step 3: Check if the directory exists
        if (!file.exists()) {
            System.out.println("The specified directory does not exist.");
            return;
        }

        // Step 4: Check if the directory is a directory
        if (!file.isDirectory()) {
            System.out.println("The specified item is not a directory.");
            return;
        }

        // Step 5: Scan the directory
        try {
            File[] listOfFiles = file.listFiles();
            for (File fileListOfFiles : listOfFiles) {
                if (fileListOfFiles.isFile()) {
                    // Step 6: Print the file name and size
                    System.out.println("File Name: " + fileListOfFiles.getName());
                    System.out.println("File Size: " + fileListOfFiles.length() + " bytes");
                } else if (fileListOfFiles.isDirectory()) {
                    // Step 7: Print the directory name
                    System.out.println("Directory Name: " + fileListOfFiles.getName());
                }
            }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}