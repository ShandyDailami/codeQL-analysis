import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_38946_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The directory does not exist.");
            return;
        }

        if (directory.list().length == 0) {
            System.out.println("The directory is empty.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Could not list files in the directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                handleFile(file);
            } else if (file.isDirectory()) {
                handleDirectory(file);
            }
        }
    }

    private static void handleFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Add security-sensitive operation here
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }

    private static void handleDirectory(File directory) {
        // Handle directory here
    }
}