import java.io.File;
import java.util.Scanner;

public class java_28455_FileScanner_A01 {
    private static final String DIR = "C:\\path\\to\\directory";
    private static final String EXT = ".*";

    public static void main(String[] args) {
        SecurityScanner scanner = new SecurityScanner();
        File file = new File(DIR);
        scanner.scan(file, file.getPath() + EXT);
    }

    private void scan(File directory, String pattern) {
        if (!directory.exists()) {
            System.out.println("Directory does not exist: " + directory);
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                scan(file, pattern);
            } else {
                if (file.getName().matches(pattern)) {
                    System.out.println("Security-sensitive operation found in: " + file.getPath());
                }
            }
        }
    }
}