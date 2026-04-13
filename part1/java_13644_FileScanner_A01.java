import java.io.File;
import java.io.IOException;
import java.security.Permission;

public class java_13644_FileScanner_A01 {

    private final File rootDir;

    public java_13644_FileScanner_A01(File rootDir) {
        this.rootDir = rootDir;
    }

    public void scanDir(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDir(file);
                } else {
                    processFile(file);
                }
            }
        }
    }

    public void processFile(File file) {
        // Implement your security-sensitive operations here
        // This is a placeholder and doesn't do anything in this example
        System.out.println("Processing file: " + file.getAbsolutePath());
    }

    public static void main(String[] args) {
        File rootDir = new File(".");
        try {
            new SecureFileScanner(rootDir).scanDir(rootDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}