import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14777_FileScanner_A03 {
    public static void main(String[] args) {
        // Get the directory path
        String directoryPath = args[0];

        // Create a new file object
        File directory = new File(directoryPath);

        // Scan all files and subdirectories
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // This is a file
                    try {
                        // Create a scanner for the file
                        Scanner scanner = new Scanner(file);

                        // While there are more tokens, handle them
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }

                        // Close the scanner
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    // This is a directory
                    System.out.println("Directory: " + file.getAbsolutePath());
                    listFiles(file);
                }
            }
        }
    }

    private static void listFiles(File directory) {
        // Scan all files and subdirectories
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // This is a file
                    try {
                        // Create a scanner for the file
                        Scanner scanner = new Scanner(file);

                        // While there are more tokens, handle them
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }

                        // Close the scanner
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    // This is a directory
                    System.out.println("Directory: " + file.getAbsolutePath());
                    listFiles(file);
                }
            }
        }
    }
}