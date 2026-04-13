import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class java_13698_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter directory path:");
            String path = scanner.nextLine();

            try {
                directory = new File(path);
            } catch (Exception e) {
                System.out.println("Invalid directory path!");
                return;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found!");
            return;
        } catch (IOException e) {
            System.out.println("Error reading input!");
            return;
        }

        listDirectory(directory);
    }

    private static void listDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    listDirectory(file);
                }
            }
        }
    }
}