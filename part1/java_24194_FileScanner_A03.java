import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_24194_FileScanner_A03 {
    public static void main(String[] args) {
        // Read user input to get the directory
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a FileScanner
        FileScanner fileScanner = new FileScanner(directoryPath);

        // Start scanning
        fileScanner.start();

        // Wait for user input to stop the scanning
        while (true) {
            System.out.println("Enter 'stop' to stop scanning:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }
        }

        // Stop scanning
        fileScanner.stop();

        scanner.close();
    }

    static class FileScanner {
        private File directory;
        private boolean isScanning;

        public java_24194_FileScanner_A03(String directoryPath) {
            this.directory = new File(directoryPath);
        }

        public void start() {
            if (isScanning) {
                System.out.println("Scanner is already scanning.");
                return;
            }

            isScanning = true;

            // Recursively scan files in directory
            scanDirectory(directory);
        }

        public void stop() {
            isScanning = false;
        }

        private void scanDirectory(File directory) {
            File[] files = directory.listFiles();

            if (files != null) {
                Arrays.stream(files)
                        .filter(file -> file.isFile() && !file.getName().endsWith(".java"))
                        .forEach(file -> System.out.println("Found non-Java file: " + file.getPath()));
            }

            if (directory.isDirectory()) {
                Arrays.stream(directory.listFiles())
                        .filter(FileScanner::isScanning)
                        .forEach(this::scanDirectory);
            }
        }

        private static boolean isScanning(File file) {
            // This method is used to filter non-Java files during the scanning process
            // You can use a different method to filter the files as per your requirements
            return file.getName().endsWith(".java");
        }
    }
}