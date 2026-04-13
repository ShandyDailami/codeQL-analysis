import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40811_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        String extension = ".txt"; // replace with your extension

        File dir = new File(directory);
        File[] files = dir.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            int numFiles = files.length;
            long totalSize = totalSize(files);

            System.out.println("Number of files: " + numFiles);
            System.out.println("Total size: " + totalSize);
        } else {
            System.out.println("No files found!");
        }
    }

    private static long totalSize(File[] files) {
        long total = 0;
        for (File file : files) {
            total += file.length();
        }
        return total;
    }
}