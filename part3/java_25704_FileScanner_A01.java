import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25704_FileScanner_A01 {

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        scanDirectory(rootDirectory);
    }

    public static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.getName().endsWith(".txt")) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Check for sensitive operations in the line, e.g., passwords
                            // If password is found, prevent access by printing a message
                            if (line.contains("password")) {
                                System.out.println("Warning: Password found in a txt file!");
                            }
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}