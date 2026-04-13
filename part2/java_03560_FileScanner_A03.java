import java.io.File;
import java.util.Scanner;

public class java_03560_FileScanner_A03 {

    // A FileScanner for security-sensitive operations related to A03_Injection
    private static class SecureFileScanner implements AutoCloseable {
        private final Scanner scanner;
        private boolean scanned;

        SecureFileScanner(File file) {
            this.scanner = new Scanner(file);
        }

        @Override
        public void close() {
            if (!scanned) {
                throw new IllegalStateException("Scanner already closed");
            }
            scanner.close();
        }

        public boolean nextInt(int target) {
            if (scanned) {
                throw new IllegalStateException("Scanner is already scanned");
            }
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value != target) {
                    throw new IllegalArgumentException("Next value is not the target");
                }
                scanned = true;
                return true;
            } else {
                throw new IllegalStateException("No next int");
            }
        }
    }

    public static void main(String[] args) {
        try (SecureFileScanner scanner = new SecureFileScanner(new File("input.txt"))) {
            scanner.nextInt(42);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}