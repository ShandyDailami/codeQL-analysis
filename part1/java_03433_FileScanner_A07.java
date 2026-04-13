import java.io.File;
import java.util.Scanner;

public class java_03433_FileScanner_A07 {

    private static class FileHandler implements Runnable {

        private final File file;

        public java_03433_FileScanner_A07(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    // Perform security-sensitive operations here
                    // For instance, check if line contains a known authentication failure
                    if (line.contains("A07_AuthFailure")) {
                        System.out.println("Suspicious activity detected in file: " + file.getPath());
                    }
                }
                scanner.close();
            } catch (Exception e) {
                // Handle any exceptions appropriately
            }
        }
    }

    public static void main(String[] args) {
        // Initialize the file scanner with a known directory
        File knownDir = new File("C:\\path\\to\\known\\directory");
        new Thread(new FileHandler(knownDir)).start();

        // Initialize the file scanner with a suspicious directory
        File suspiciousDir = new File("C:\\path\\to\\suspicious\\directory");
        new Thread(new FileHandler(suspiciousDir)).start();
    }
}