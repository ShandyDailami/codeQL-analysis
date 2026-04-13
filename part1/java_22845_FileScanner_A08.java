import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_22845_FileScanner_A08 {

    public static void main(String[] args) {

        // Use System.getProperty("user.dir") to get the directory of the user running the code
        String directoryPath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\example";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    scanFile(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static void scanDirectory(File directory) {
        System.out.println("Scanning directory: " + directory.getPath());
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    scanFile(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        try {
            System.out.println("Scanning file: " + file.getPath());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // Here is where you'd implement your security-sensitive operations
                // For example, checking file's integrity
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Failed to scan file: " + file.getPath());
        }
    }
}