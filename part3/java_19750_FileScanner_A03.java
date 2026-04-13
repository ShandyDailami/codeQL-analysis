import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19750_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with actual directory path
        File directory = new File(directoryPath);

        // Print system-related information
        System.out.println("Listing files in directory: " + directory.getAbsolutePath());

        // Use File.listFiles() to get a list of files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // Check if file is a regular file
                if (file.isFile()) {
                    // Check if file is hidden (starts with '.')
                    if (file.getName().startsWith(".")) {
                        // Print hidden file name and contents
                        System.out.println("Hidden file: " + file.getName());
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                System.out.println("File contents: " + scanner.nextLine());
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("Error reading file: " + file.getName());
                        }
                    } else {
                        // Print regular file name and contents
                        System.out.println("File: " + file.getName());
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                System.out.println("File contents: " + scanner.nextLine());
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("Error reading file: " + file.getName());
                        }
                    }
                }
            }
        }
    }
}