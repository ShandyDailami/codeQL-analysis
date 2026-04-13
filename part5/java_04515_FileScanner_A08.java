import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class java_04515_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        processDirectory(directory);
    }

    private static void processDirectory(File directory) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    processDirectory(file);
                } else if (file.isFile() && file.length() > 500) {
                    File newFile = new File(directory, "new_" + file.getName());
                    Files.copy(file.toPath(), newFile.toPath(), StandardOpenOption.REPLACE_EXISTING);
                    System.out.println("Copied file: " + file.getAbsolutePath());
                }
            }
        }
    }
}