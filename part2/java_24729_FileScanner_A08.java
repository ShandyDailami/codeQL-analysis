import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_24729_FileScanner_A08 {
    private static final String DIR = "src/main/java";

    public static void main(String[] args) {
        SecurityFileScanner scanner = new SecurityFileScanner();
        scanner.scan(DIR);
    }

    private void scan(String directory) {
        File root = new File(directory);
        File[] files = root.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                // Accept all files (ignoring directories)
                return pathname.isFile();
            }
        });

        // If files exist, print them
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}