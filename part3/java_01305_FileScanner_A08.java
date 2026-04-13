import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class java_01305_FileScanner_A08 {

    private Set<File> suspiciousFiles = new HashSet<>();
    private Set<File> trustedFiles = new HashSet<>();

    public void scan(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file);
                } else {
                    checkFile(file);
                }
            }
        }
    }

    private void checkFile(File file) {
        try {
            byte[] data = Files.readAllBytes(file.toPath());
            // Here, you can use a security-sensitive operation, like checking the file's hash or signature, to verify the file's integrity.
            // For simplicity, we'll just write it out.
            Files.write(file.toPath(), data, StandardOpenOption.CREATE);
        } catch (Exception e) {
            suspiciousFiles.add(file);
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scan(new File("path_to_directory"));
        // Print out the suspicious files.
        for (File file : scanner.suspiciousFiles) {
            System.out.println("Suspicious file: " + file.getAbsolutePath());
        }
    }
}