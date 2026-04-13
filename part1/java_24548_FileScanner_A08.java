import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileSystemNotFoundException;

public class java_24548_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // Replace with your directory path
        String extension = ".txt"; // Replace with your file extension

        try {
            Path path = FileSystems.getDefault().getPath(dirPath);
            scanDirectory(path, extension);
        } catch (FileSystemNotFoundException e) {
            System.out.println("File System not found: " + e.getMessage());
        }
    }

    private static void scanDirectory(Path path, String extension) {
        try {
            // Recursively traverse directory tree
            Files.walk(path)
            // Only accept file with specified extension
            .filter(Files::isRegularFile)
            .forEach(Main::printFileDetails);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printFileDetails(Path path) {
        File file = path.toFile();
        long size = Files.size(path);
        System.out.println(file.getName() + " - " + file.getAbsolutePath() + " - " + size + " bytes");
    }
}