import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class java_17330_FileScanner_A07 {
    public static void main(String[] args) {
        File root = new File("/path/to/directory");
        filterBySize(root, 1024);  // Example: filter files larger than 1024 bytes
    }

    public static void filterBySize(File root, long size) {
        File[] files = root.listFiles();
        if (files == null) return;

        Arrays.sort(files, Comparator.comparing(File::length));

        for (File file : files) {
            if (file.length() > size) {
                System.out.println("File: " + file.getAbsolutePath());
            } else {
                // recursively call filterBySize on subdirectories
                filterBySize(file, size);
            }
        }
    }
}