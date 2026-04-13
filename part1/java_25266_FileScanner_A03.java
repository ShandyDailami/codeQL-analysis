import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_25266_FileScanner_A03 {
    public static void main(String[] args) {
        // Define a directory path
        Path path = Paths.get("your_directory_path");

        // Start scanning the directory
        scanDirectory(path);
    }

    public static void scanDirectory(Path path) {
        File directory = path.toFile();

        // Get all files in the directory
        File[] files = directory.listFiles();

        // Check if the directory is not null
        if (files != null) {
            // Iterate over all files
            for (File file : files) {
                if (file.isFile()) {
                    // Check if the file is a text file
                    if (file.getName().endsWith(".txt")) {
                        long lineCount = countLines(file);
                        System.out.println("Number of lines in " + file.getName() + ": " + lineCount);
                    }
                } else if (file.isDirectory()) {
                    // If the file is a directory, recursively scan it
                    scanDirectory(file.toPath());
                }
            }
        }
    }

    public static long countLines(File file) {
        long lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineCount;
    }
}