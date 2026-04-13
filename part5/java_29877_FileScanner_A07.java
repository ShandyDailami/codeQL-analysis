import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_29877_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        Path startingDirectory = Paths.get(directoryPath);

        try {
            Files.walk(startingDirectory)
                    .filter(Files::isRegularFile)
                    .filter(file -> file.getFileName().toString().endsWith(".txt"))
                    .forEach(file -> {
                        System.out.println("File found: " + file.getFileName());
                    });
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}