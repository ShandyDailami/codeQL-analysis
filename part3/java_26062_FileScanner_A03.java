import java.io.File;
import java.util.Scanner;

public class java_26062_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");
        String targetPattern = "A03_Injection";

        SecurityScanner scanner = new SecurityScanner(directory, targetPattern);
        scanner.scan();
    }
}

class SecurityScanner {
    private File directory;
    private String targetPattern;

    public java_26062_FileScanner_A03(File directory, String targetPattern) {
        this.directory = directory;
        this.targetPattern = targetPattern;
    }

    public void scan() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    if (containsPattern(file, targetPattern)) {
                        System.out.println("Found file: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    scan(file);
                }
            }
        }
    }

    private boolean containsPattern(File file, String pattern) {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(pattern)) {
                return true;
            }
        }
        return false;
    }

    private void scan(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    if (containsPattern(file, targetPattern)) {
                        System.out.println("Found file in directory: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    scan(file);
                }
            }
        }
    }
}