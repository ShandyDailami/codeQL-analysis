import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28943_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);
        File lastModifiedFile = null;

        while (true) {
            File[] files = directory.listFiles();
            if (files == null) {
                throw new RuntimeException("Could not list files in directory: " + directoryPath);
            }

            for (File file : files) {
                if (file.isFile() && (lastModifiedFile == null || file.lastModified() > lastModifiedFile.lastModified())) {
                    lastModifiedFile = file;
                    printFileDetails(file);
                }
            }

            try {
                Thread.sleep(5000); // Wait for 5 seconds before scanning again
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getAbsolutePath());
        System.out.println("Last modified: " + file.lastModified());
        System.out.println();
    }
}