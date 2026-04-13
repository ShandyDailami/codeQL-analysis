import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28780_FileScanner_A07 {
    public static void main(String[] args) {
        // Prompt user for directory path
        System.out.println("Please enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String dirPath = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(dirPath);

        // Check if directory exists
        if (!dir.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        // Check if directory is a file
        if (dir.isFile()) {
            System.out.println("The path you provided is not a directory.");
            return;
        }

        // Iterate over all files in the directory
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files in the directory.");
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                try {
                    // Create a Scanner for the file
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getPath());
                }
            }
        }
    }
}