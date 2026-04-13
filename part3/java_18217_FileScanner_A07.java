import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_18217_FileScanner_A07 {
    private static final Set<String> SAFE_FILE_EXTENSIONS = new HashSet<>(Arrays.asList("txt", "md", "html"));

    public void scan(String rootDirectory) {
        File file = new File(rootDirectory);

        if (!file.exists()) {
            System.out.println("Root directory does not exist!");
            return;
        }

        if (!file.isDirectory()) {
            System.out.println("Provided root directory is not a directory!");
            return;
        }

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }

                String name = pathname.getName();
                int lastDot = name.lastIndexOf(".");

                if (lastDot == -1) {
                    return false;
                }

                String extension = name.substring(lastDot + 1).toLowerCase();
                return SAFE_FILE_EXTENSIONS.contains(extension);
            }
        };

        File[] files = file.listFiles(filter);

        if (files == null) {
            System.out.println("Failed to list files in root directory!");
            return;
        }

        for (File fileToScan : files) {
            System.out.println("Scanning file: " + fileToScan.getAbsolutePath());

            // Place your security-sensitive operations here

            System.out.println("-----------------");
        }
    }
}