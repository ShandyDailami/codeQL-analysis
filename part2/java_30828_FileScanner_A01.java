import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_30828_FileScanner_A01 {
    private final static Set<String> SUPPORTED_EXTENSIONS = new HashSet<>(Arrays.asList("txt", "csv", "log", "xml"));
    private final File rootDirectory;

    public java_30828_FileScanner_A01(File rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public void scan() {
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                String name = pathname.getName();
                String extension = "";

                // Extract the extension from the filename
                if (name.lastIndexOf('.') != -1) {
                    extension = name.substring(name.lastIndexOf('.') + 1);
                }

                return SUPPORTED_EXTENSIONS.contains(extension);
            }
        };

        File[] files = rootDirectory.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Ignore directories
                    continue;
                }

                // Here you could add your security-sensitive operations related to A01_BrokenAccessControl
                System.out.println("Processing file: " + file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        SecureFileScanner scanner = new SecureFileScanner(rootDirectory);
        scanner.scan();
    }
}