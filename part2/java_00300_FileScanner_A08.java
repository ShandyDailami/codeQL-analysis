import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class java_00300_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Input is not a directory");
            return;
        }

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles == null) {
            System.out.println("No .txt files in the directory");
            return;
        }

        for (File file : txtFiles) {
            Path path = Paths.get(file.getPath());
            long length = Files.size(path);
            System.out.printf("File: %s, Size: %d bytes%n", file.getName(), length);
        }
    }
}