import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class java_34128_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            Path path = Paths.get(directoryPath);

            if (Files.exists(path) && Files.isDirectory(path)) {
                Files.newFileScanner(path).useTraversalOrder().forEach(file -> {
                    if (file.toString().endsWith(".txt")) {
                        System.out.println(file.toString());
                    }
                });
            } else {
                System.out.println("Invalid directory or it is not a directory");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while accessing the directory or file");
        }
    }
}