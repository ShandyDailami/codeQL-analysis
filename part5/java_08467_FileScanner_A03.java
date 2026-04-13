import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08467_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        // Get the directory path from user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(dirPath);

        // If the directory does not exist or is not a directory, print an error message
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        // Get all files from the directory
        File[] files = dir.listFiles();

        // If there are no files, print an error message
        if (files == null) {
            System.out.println("Directory is empty");
            return;
        }

        // Print the contents of each file
        for (File file : files) {
            if (file.isFile() && file.canRead()) {
                System.out.println("File: " + file.getName());
                System.out.println("Contents:");
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            }
        }
    }
}