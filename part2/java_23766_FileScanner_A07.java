import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23766_FileScanner_A07 {
    private static final String TARGET_FILE = "target_file.txt";

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.startScanning();
    }

    public static class FileScanner {
        private Scanner scanner;

        public java_23766_FileScanner_A07() {
            this.scanner = new Scanner(System.in);
        }

        public void startScanning() {
            String currentPath = System.getProperty("user.dir");
            File startingDirectory = new File(currentPath);

            scanDirectory(startingDirectory);
        }

        private void scanDirectory(File directory) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isHidden()) {
                        System.out.println("Skipping hidden file: " + file.getName());
                    } else if (file.getName().equalsIgnoreCase(TARGET_FILE)) {
                        System.out.println("Found target file!");
                        scanner.close();
                    } else {
                        System.out.println("Scanning file: " + file.getName());
                        scanner.nextLine(); // Use scanner to read file content
                    }

                    if (file.isDirectory()) {
                        scanDirectory(file);
                    }
                }
            }
        }
    }
}