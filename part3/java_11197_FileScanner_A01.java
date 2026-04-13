import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class java_11197_FileScanner_A01 {
    private static final String ROOT_DIRECTORY = "/path/to/root/directory";

    public static void main(String[] args) {
        SecurityScanner scanner = new SecurityScanner();
        File root = new File(ROOT_DIRECTORY);
        scanner.scanDirectory(root);
    }

    public void scanDirectory(File directory) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }

                String name = pathname.getName();
                return name.endsWith(".exe") || name.endsWith(".dll");
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(this::scanFile);
        }
    }

    public void scanFile(File file) {
        try {
            System.out.println("Scanning file: " + file.getAbsolutePath());
            // Place your security-sensitive operations here
            // For example, here we are checking if the file has executable permission
            if (!file.canExecute()) {
                System.out.println("Warning: File " + file.getAbsolutePath() + " has permission issue.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}