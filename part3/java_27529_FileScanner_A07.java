import java.io.File;
import java.security.SecureRandom;
import java.util.Scanner;

public class java_27529_FileScanner_A07 {
    private static final SecureRandom rng = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        File dir = new File(dirPath);
        File file = new File(dir, fileName);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        // Check if the file is readable
        if (!file.canRead()) {
            System.out.println("Cannot read the file.");
            return;
        }

        // Check if the file is writable
        if (!file.canWrite()) {
            System.out.println("Cannot write to the file.");
            return;
        }

        // Check if the file is executable
        if (!file.canExecute()) {
            System.out.println("Cannot execute the file.");
            return;
        }

        // Check if the file is a directory
        if (file.isDirectory()) {
            System.out.println("The file is a directory.");
            return;
        }

        // Check if the file is a regular file
        if (file.isFile()) {
            System.out.println("The file is a regular file.");
            return;
        }

        // Check if the file is a symbolic link
        if (file.isSymbolicLink()) {
            System.out.println("The file is a symbolic link.");
            return;
        }

        // No security failures detected
        System.out.println("No security failures detected.");
    }
}