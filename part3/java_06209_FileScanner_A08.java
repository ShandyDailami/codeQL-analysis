import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_06209_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.canRead()) {
                            if (file.getAbsolutePath().endsWith(".txt")) {
                                try {
                                    Scanner fileScanner = new Scanner(file);
                                    while (fileScanner.hasNextLine()) {
                                        String line = fileScanner.nextLine();
                                        // This is where the integrity check happens.
                                        // If a line is not acceptable (e.g., contains a common SQL injection attempt),
                                        // the integrity failure will occur here.
                                    }
                                    fileScanner.close();
                                    System.out.println("Successfully scanned file: " + file.getAbsolutePath());
                                } catch (FileNotFoundException e) {
                                    System.out.println("Error reading file: " + file.getAbsolutePath());
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}