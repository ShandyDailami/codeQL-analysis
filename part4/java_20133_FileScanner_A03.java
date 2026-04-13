import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class java_20133_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String input = scanner.nextLine();

        try {
            FileSystem fileSystem = FileSystems.newFileSystem(Paths.get(input), null);
            fileSystem.getRootDirectories().forEach(System.out::println);
            fileSystem.close();
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + input);
        } catch (IOException e) {
            System.out.println("Error accessing directory: " + input);
        }
    }
}