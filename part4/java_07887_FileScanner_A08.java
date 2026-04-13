import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class java_07887_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        try {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());

                        // Reading file with restricted permissions
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println("Line: " + line);
                            }
                        }

                        System.out.println("--------------------");
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());

                        // Recursively scanning subdirectories
                        scanDirectory(file);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void scanDirectory(File directory) throws IOException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File in subdirectory: " + file.getName());

                    // Reading file with restricted permissions
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println("Line in subdirectory: " + line);
                        }
                    }

                    System.out.println("--------------------");
                } else if (file.isDirectory()) {
                    System.out.println("Directory in subdirectory: " + file.getName());

                    // Recursively scanning subdirectories
                    scanDirectory(file);
                }
            }
        }
    }
}