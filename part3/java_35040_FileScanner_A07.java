import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_35040_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(Path path) throws IllegalArgumentException {
                // We only want to scan directories, not files.
                return Files.isDirectory(path);
            }
        };

        try (FileScanner scanner = new FileScanner(Paths.get(dirPath))) {
            for (Path path : scanner.filter(filter)) {
                printDirectoryContent(path, scanner);
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }

    private static void printDirectoryContent(Path path, FileScanner scanner) {
        System.out.println("Scanning directory: " + path);
        try (FileScanner subScanner = new FileScanner(path)) {
            for (File file : subScanner.files()) {
                System.out.println("  File: " + file.getPath());
            }
        } catch (IOException e) {
            System.out.println("Error reading files in directory: " + e.getMessage());
        }
    }
}