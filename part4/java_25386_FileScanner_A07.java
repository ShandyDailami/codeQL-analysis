import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class java_25386_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(dirPath))) {
            for (Path path : dirStream) {
                if (Files.isRegularFile(path)) {
                    try (Scanner fileScanner = new Scanner(path)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}