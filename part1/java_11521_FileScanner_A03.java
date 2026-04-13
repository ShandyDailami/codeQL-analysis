import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11521_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path

        File directory = new File(directoryPath);
        File[] subFiles = directory.listFiles();

        if (subFiles != null) {
            for (File file : subFiles) {
                if (file.isFile()) {
                    readFile(file);
                } else if (file.isDirectory()) {
                    readDirectory(file);
                }
            }
        }
    }

    private static void readDirectory(File directory) {
        File[] subFiles = directory.listFiles();

        if (subFiles != null) {
            for (File file : subFiles) {
                if (file.isFile()) {
                    readFile(file);
                } else if (file.isDirectory()) {
                    readDirectory(file);
                }
            }
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}