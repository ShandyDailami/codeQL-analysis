import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08814_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = args[0];  // Get directory path from command line arguments

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Given path is not a directory!");
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File path: " + file.getAbsolutePath());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}