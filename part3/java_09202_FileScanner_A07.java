import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09202_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        // Verify if the directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        // Verify if the directory is a directory
        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files in the directory.");
            return;
        }

        // Print all files
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            }
        }

        // Read and execute each file
        for (File file : files) {
            if (file.isFile()) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println("Line in file: " + line);
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error reading file: " + file.getName());
                }
            }
        }
    }
}