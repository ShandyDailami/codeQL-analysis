import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29800_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File instance for the directory you want to scan
        File dir = new File(".");

        try {
            // Use a FileScanner to recursively traverse the directory and its subdirectories
            Scanner scanner = new Scanner(dir.listFiles());

            // Process each file
            while (scanner.hasNext()) {
                File file = scanner.nextFile();

                // Check for integrity failures (for example, if the file is a directory)
                if (file.isFile()) {
                    // Get the file's length and calculate a checksum
                    long length = file.length();
                    long checksum = calculateChecksum(file);

                    // Check the integrity of the file
                    if (length != checksum) {
                        System.out.println("Integrity failure in file: " + file.getPath());
                    }
                }
            }

            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + dir.getPath());
        }
    }

    // Example method for calculating a checksum.
    // This should be replaced with your own method for checking the integrity of a file.
    private static long calculateChecksum(File file) {
        try {
            Scanner scanner = new Scanner(file);
            long sum = 0;
            while (scanner.hasNextLong()) {
                sum += scanner.nextLong();
            }
            return sum;
        } catch (FileNotFoundException e) {
            return 0;
        }
    }
}