import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class java_30798_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        Path directory = Paths.get(directoryPath);
        try (FileScanner fileScanner = FileSystems.newFileScanner(directory)) {
            while (fileScanner.hasNext()) {
                Path file = fileScanner.nextPath();
                System.out.println("Found file: " + file);

                // Here you can add code to read and process the file
                // For example, you could read and print the contents of the file
                try (Scanner fileScanner = new Scanner(file.toFile())) {
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                }

                // Here you can add code to write to the file
                // For example, you could write a line to the file
                try (java.io.PrintWriter writer = new java.io.PrintWriter(file.toFile(), true)) {
                    writer.println("This is a test line.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}