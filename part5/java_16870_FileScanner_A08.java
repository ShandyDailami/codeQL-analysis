import java.io.File;
import java.util.Scanner;

public class java_16870_FileScanner_A08 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: FileScannerExample <directory>");
            return;
        }

        File directory = new File(args[0]);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Provided argument is not a directory.");
            return;
        }

        System.out.println("Scanning directory: " + directory.getPath());
        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Error listing files in directory.");
            return;
        }

        int fileCount = 0;
        for (File file : files) {
            if (file.isFile()) {
                fileCount++;
                System.out.println("Found file: " + file.getPath());
            }
        }

        System.out.println("Total files: " + fileCount);
    }
}