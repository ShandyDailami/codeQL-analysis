import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_40340_FileScanner_A01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingPath = Paths.get(".").toAbsolutePath(); // Change this to the directory you want to scan.

        // Prints out all files in a directory and its subdirectories.
        Files.walk(startingPath, 1)
             .filter(Files::isRegularFile)
             .forEach(FileScanner::printFileDetails);

        // Prints out all directories in a directory and its subdirectories.
        Files.walk(startingPath, 1)
             .filter(Files::isDirectory)
             .forEach(FileScanner::printDirectoryDetails);
    }

    private static void printFileDetails(Path file) {
        System.out.println("File: " + file.toString());
    }

    private static void printDirectoryDetails(Path dir) {
        System.out.println("Directory: " + dir.toString());
    }
}