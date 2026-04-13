import java.io.File;
import java.util.Scanner;

public class java_31758_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();
            for (String fileName : files) {
                File file = new File(directoryPath + "/" + fileName);

                // Security-sensitive operation related to injection
                // This is a placeholder for a security-sensitive operation.
                // It should be replaced with a real operation.
                if (file.isFile()) {
                    System.out.println("File: " + fileName);
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + fileName);
                }
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}