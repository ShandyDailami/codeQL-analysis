import java.io.File;
import java.util.Scanner;

public class java_16014_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "."; // Default directory path

        if (args.length > 0) {
            directoryPath = args[0]; // If argument is provided, use it as directory path
        }

        File rootDirectory = new File(directoryPath);

        if (rootDirectory.exists() && rootDirectory.isDirectory()) {
            scanDirectory(rootDirectory);
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    scanFile(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        if (file.getName().endsWith(".txt")) {
            System.out.println("Found text file: " + file.getAbsolutePath());
        } else if (file.getName().endsWith(".png")) {
            System.out.println("Found image file: " + file.getAbsolutePath());
        } else {
            System.out.println("Found unknown file type: " + file.getAbsolutePath());
        }
    }
}