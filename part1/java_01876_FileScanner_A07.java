import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_01876_FileScanner_A07 {
    private static final File[] roots = File.listRoots();
    private static final String TXT_EXTENSION = ".txt";

    public static void main(String[] args) {
        scanDirectory(new File("/"));
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // only include txt files
                return pathname.isFile() && pathname.getName().endsWith(TXT_EXTENSION);
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    // Perform some security-sensitive operation here...
                    // For now, just print out the file name
                    System.out.println("Found file: " + file.getPath());
                } else {
                    System.out.println("Cannot read file: " + file.getPath());
                }
            }
        }

        // Now, recursively scan subdirectories
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                scanDirectory(file);
            }
        }
    }
}