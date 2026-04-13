import java.io.File;
import java.util.Scanner;

public class java_38673_FileScanner_A08 {
    private File rootDirectory;

    public java_38673_FileScanner_A08(File rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public void scanForIntegrityFailureFiles(String extension, FileCallback callback) {
        File root = this.rootDirectory;
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    callback.call(file);
                } else if (file.isDirectory()) {
                    scanForIntegrityFailureFiles(extension, callback);
                }
            }
        }
    }

    public interface FileCallback {
        void call(File file);
    }

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        SecureFileScanner scanner = new SecureFileScanner(rootDirectory);
        scanner.scanForIntegrityFailureFiles(".a08", file -> {
            System.out.println("Integrity failure detected in file: " + file.getAbsolutePath());
        });
    }
}