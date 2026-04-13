import java.io.*;
import java.util.*;

public class java_09134_FileScanner_A08 {
    private static final String FILE_EXTENSION = ".txt";
    private static final String DIRECTORY_PATH = "/path/to/dir";

    public static void main(String[] args) {
        try {
            scanDirectory(DIRECTORY_PATH);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void scanDirectory(String directoryPath) throws Exception {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            throw new Exception("Directory not found: " + directoryPath);
        }
        if (!directory.isDirectory()) {
            throw new Exception("Path is not a directory: " + directoryPath);
        }

        File[] files = directory.listFiles();
        if (files == null) {
            throw new Exception("Failed to list files in directory: " + directoryPath);
        }

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(FILE_EXTENSION)) {
                readFile(file);
            } else if (file.isDirectory()) {
                scanDirectory(file.getPath());
            }
        }
    }

    private static void readFile(File file) throws Exception {
        // Error handling for A08_IntegrityFailure
        if (!file.canRead()) {
            throw new Exception("File is not readable: " + file.getPath());
        }

        // Read and print the content of the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}