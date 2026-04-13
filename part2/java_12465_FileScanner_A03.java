import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12465_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Injection detection example: check for string injection in a line
                                if (line.contains("password=")) {
                                    System.out.println("String injection detected in file: " + file.getName());
                                }
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}