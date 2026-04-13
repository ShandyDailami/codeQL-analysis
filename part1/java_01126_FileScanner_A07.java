import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Set;

public class java_01126_FileScanner_A07 {
    private static final Set<String> SENSITIVE_FILES = new HashSet<>();

    static {
        SENSITIVE_FILES.add(".txt");
        SENSITIVE_FILES.add(".sql");
        SENSITIVE_FILES.add(".xml");
        // Add more sensitive file types here if needed
    }

    public static void main(String[] args) {
        File directory = new File("your/directory/path");

        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt") || name.endsWith(".sql") || name.endsWith(".xml");
            }
        });

        if (files != null) {
            for (File file : files) {
                if (isSensitiveFile(file)) {
                    System.out.println("Found sensitive file: " + file.getAbsolutePath());
                }
            }
        }
    }

    private static boolean isSensitiveFile(File file) {
        // Check if the file's name contains any of the sensitive file extensions
        String name = file.getName();
        int lastDot = name.lastIndexOf(".");
        if (lastDot == -1) {
            return false;
        }
        String extension = name.substring(lastDot + 1);
        return SENSITIVE_FILES.contains(extension);
    }
}