import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_40542_FileScanner_A03 {
    private static final String EXTENSION = ".java";

    public static void main(String[] args) {
        List<File> files = new ArrayList<>();

        // Get the list of roots
        File[] roots = File.listRoots();

        // Scan each root
        for (File root : roots) {
            // Get the list of files in the root
            File[] rootFiles = root.listFiles();

            // If there are no files in the root, skip it
            if (rootFiles == null) continue;

            // Scan each file in the root
            for (File file : rootFiles) {
                // If the file is not a directory, skip it
                if (!file.isDirectory()) {
                    // If the file's name ends with the extension, add it to the list
                    if (file.getName().endsWith(EXTENSION)) {
                        files.add(file);
                    }
                }
            }
        }

        // Print the list of files
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}