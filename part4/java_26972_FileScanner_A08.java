import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_26972_FileScanner_A08 {
    public static void main(String[] args) {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                if (pathname.getName().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        };

        File rootDirectory = new File(".");
        scanDirectory(rootDirectory, fileFilter);
    }

    private static void scanDirectory(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file, filter);
            } else {
                System.out.println("Processing file: " + file.getAbsolutePath());
                // Add your security-sensitive operations here
            }
        }
    }
}