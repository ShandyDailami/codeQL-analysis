import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29271_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object for the directory we want to scan
        File directory = new File(".");

        // Create a Scanner object to read the directory contents
        Scanner scanner = new Scanner(directory.listFiles());

        // Use a for-each loop to iterate over all the files in the directory
        for (File file : directory.listFiles()) {
            // Check if the file is a directory
            if (file.isFile()) {
                try {
                    // Create a Scanner object to read the file content
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNext()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        scanner.close();
    }
}