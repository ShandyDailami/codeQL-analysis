import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38858_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "C:/directory/to/scan"; // specify your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] allFiles = directory.listFiles();
            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isFile()) {
                        try {
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // check for sensitive operations here
                                if (line.contains("password")) {
                                    System.out.println("Sensitive operation detected in file: " + file.getAbsolutePath());
                                }
                           
                            }
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getAbsolutePath());
                        }
                    } else if (file.isDirectory()) {
                        // recursively scan directories
                        scanDirectory(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }

    private static void scanDirectory(File directory) {
        // recursively scan directories
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // process file
                } else if (file.isDirectory()) {
                    // recursively scan directories
                    scanDirectory(file);
                }
            }
        }
    }
}