import java.io.File;
import java.io.FileFilter;

public class java_11114_FileScanner_A07 {
    public static void main(String[] args) {
        File root = new File("."); // The current directory
        printFilesInDirectory(root, "");
    }

    private static void printFilesInDirectory(File directory, String prefix) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // We're only interested in regular files, not directories
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(prefix + file.getName());
                // Recursively print files in subdirectories
                printFilesInDirectory(file, prefix + " ├── ");
            }
        }
    }
}