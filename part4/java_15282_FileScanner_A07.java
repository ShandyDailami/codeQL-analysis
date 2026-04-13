import java.io.File;
import java.util.Scanner;

public class java_15282_FileScanner_A07 {
    private static final String AUTH_FAILURE_DIR = "src/main/resources/auth_failure_files/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the file path:");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        try {
            FileScanner fileScanner = new FileScanner(file);
            fileScanner.scan();
            System.out.println("File scanned successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}