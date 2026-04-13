import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07821_FileScanner_A03 {

    public static void main(String[] args) {

        // Create a File object that represents the directory to be scanned
        File directory = new File("src");

        // Use a try-with-resources statement to ensure that the Scanner closes the directory when we're done with it
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the file extension to search for:");

            // Read the file extension from the user
            String fileExtension = scanner.next();

            // Use the File.listFiles method to get an array of all files in the directory and its subdirectories
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    // Check if the file is a directory (not a file)
                    if (file.isFile() && file.getName().endsWith("." + fileExtension)) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
    }
}