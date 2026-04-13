import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22076_FileScanner_A08 {

    // Create a method to check the integrity of a file
    public static boolean checkFileIntegrity(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return false;
        }

        if (!file.canRead()) {
            System.out.println("File is not readable: " + filePath);
            return false;
        }

        long length = file.length();

        // Assume the file is not corrupted if its length is less than 100 bytes
        if (length < 100) {
            return true;
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            scanner.nextLong();
            scanner.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + filePath);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        checkFileIntegrity("/path/to/your/file");
    }
}