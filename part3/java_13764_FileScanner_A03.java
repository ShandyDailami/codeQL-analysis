import java.io.*;
import java.nio.file.*;

public class java_13764_FileScanner_A03 {
    public static void main(String[] args) {
        // Specify the directory to scan
        Path directory = Paths.get("path_to_your_directory");

        try (FileSystem fs = directory.getFileSystem()) {
            // Use the FileSystem's list method to get a list of all files in the directory
            // We'll use a try-with-resources statement to ensure the FileSystem is closed after we're done
            try (DirectoryStream<Path> dirs = fs.newDirectoryStream(directory)) {
                for (Path file : dirs) {
                    // Get the file name and its length
                    String name = file.getFileName().toString();
                    long length = fs.getFileAttributeView(file, AFileAttributes.class).size();

                    // Print the file name and length
                    System.out.println("File: " + name + ", Length: " + length);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}