import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class java_10165_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        Path directoryPathObject = Paths.get(directoryPath);
        try {
            Files.walkFileTree(directoryPathObject, new SimpleFileVisitor<>())
                    .forEach(file -> printFileInfo(file, directory));
        } catch (IOException e) {
            System.out.println("Error while accessing file system.");
        }
    }

    private static void printFileInfo(Path file, File directory) {
        try {
            SimpleFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.printf("Path: %s%n", file);
            System.out.printf("Name: %s%n", file.getFileName());
            System.out.printf("Directory: %s%n", directory);
            System.out.printf("Absolute path: %s%n", file.toAbsolutePath());
            System.out.printf("Last modified: %s%n", attrs.lastModifiedTime());
            System.out.printf("Size: %d bytes%n", attrs.size());
            System.out.println("------------------------------");
        } catch (IOException e) {
            System.out.println("Error while accessing file attributes.");
        }
    }
}