import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class java_04097_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String dir = scanner.nextLine();

        File directory = new File(dir);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The provided path is not a directory.");
            return;
        }

        printFilesInDirectory(directory, "");
    }

    private static void printFilesInDirectory(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, indent + "  ");
                } else {
                    try {
                        Files.readAllLines(file.toPath()).forEach(System.out::println);
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                }
            }
        }
    }
}