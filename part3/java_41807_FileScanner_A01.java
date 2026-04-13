import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41807_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        // Ensure directory exists and is readable
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                try (Scanner scanner = new Scanner(file)) {
                    int lineCount = 0;
                    while (scanner.hasNextLine()) {
                        scanner.nextLine();
                        lineCount++;
                    }

                    System.out.printf("File: %s, Lines: %d%n", file.getName(), lineCount);
                } catch (FileNotFoundException e) {
                    System.out.println("Error reading file: " + file.getName());
                }
            }
        }
    }
}