import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12083_FileScanner_A08 {
    public static void main(String[] args) {
        File rootDirectory = new File(".");
        String extension = ".txt";
        processFiles(rootDirectory, extension);
    }

    public static void processFiles(File directory, String extension) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    processFile(file, extension);
                }
            }
        } else {
            System.out.println("Not a directory");
        }
    }

    public static void processFile(File file, String extension) {
        if (file.getName().endsWith(extension)) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getName());
            }
        }
    }
}