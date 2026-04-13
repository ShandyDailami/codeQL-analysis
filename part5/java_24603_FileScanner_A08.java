import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_24603_FileScanner_A08 {
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(Arrays.asList("jpg", "jpeg", "png", "txt"));

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.startScan(".", allowedExtensions -> allowedExtensions.contains(new File(filepath).getAbsoluteFile().getType()));
    }
}

class FileScanner {
    void startScan(String directoryPath, AllowedExtensionsCheck allowedExtensionsCheck) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && allowedExtensionsCheck.isAllowed(file.getName())) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    startScan(file.getAbsolutePath(), allowedExtensionsCheck);
                }
            }
        }
    }
}

interface AllowedExtensionsCheck {
    boolean isAllowed(String extension);
}