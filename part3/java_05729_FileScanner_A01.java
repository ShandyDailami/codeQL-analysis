import java.io.*;

public class java_05729_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Adjust this path as needed

        try {
            scanDirectory(directoryPath);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void scanDirectory(String directoryPath) throws Exception {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            throw new Exception("Directory not found: " + directoryPath);
        }

        File[] files = directory.listFiles();

        if (files == null) {
            throw new Exception("Error listing files in directory: " + directoryPath);
        }

        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(".txt")) {  // Adjust this condition as needed
                    processFile(file);
                }
            } else if (file.isDirectory()) {
                scanDirectory(file.getPath());
            }
        }
    }

    private static void processFile(File file) {
        // Add your security-sensitive operations here, such as reading the file, 
        // checking the file permissions, or modifying the file content.
        // For the sake of simplicity, we'll just print the file name here.
        System.out.println("Processing file: " + file.getPath());
    }
}