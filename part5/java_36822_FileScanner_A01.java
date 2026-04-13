import java.io.File;
import java.util.Arrays;

public class java_36822_FileScanner_A01 {
    public static void main(String[] args) {
        File currentDirectory = new File(".");
        scanDirectory(currentDirectory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    // Security-sensitive operations related to A01_BrokenAccessControl
                    // For example, check the file permissions
                    if (file.canRead() && file.canWrite()) {
                        System.out.println("File: " + file.getAbsolutePath() + " is accessible.");
                    } else {
                        System.out.println("File: " + file.getAbsolutePath() + " is not accessible.");
                    }
                }
            });
        }
    }
}