import java.io.File;
import java.security.SecureRandom;
import java.util.Scanner;

public class java_41005_FileScanner_A08 {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory or path does not exist!");
            return;
        }

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        File file = new File(directory, fileName);

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        long integrityFailureTime = System.currentTimeMillis() - (1000 * 60 * 60 * 24); // 24 hours
        if (file.lastModified() < integrityFailureTime) {
            System.out.println("IntegrityFailure: File was modified after 24 hours ago!");
            return;
        }

        System.out.println("File integrity checked successfully!");
    }
}