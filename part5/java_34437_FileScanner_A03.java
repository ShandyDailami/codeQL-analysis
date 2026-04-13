import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class java_34437_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File directory = new File(dirPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }
        try {
            Files.walk(Paths.get(dirPath))
                 .filter(Files::isRegularFile)
                 .forEach(FileScanner::printFileContent);
        } catch (IOException e) {
            System.out.println("An error occurred while scanning the directory");
        }
    }

    private static void printFileContent(Path path) {
        try {
            String content = Files.readString(path);
            System.out.println("File: " + path.toString());
            System.out.println("Content: " + content);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file content");
        }
    }
}