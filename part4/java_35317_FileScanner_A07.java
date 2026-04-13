import java.io.File;
import java.util.Scanner;

public class java_35317_FileScanner_A07 {
    private static File file;
    private static Scanner scanner;

    public static void main(String[] args) {
        ScannerInput();
        AuthFailure();
    }

    public static void ScannerInput() {
        System.out.println("Enter the file path:");
        scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        file = new File(path);

        if (file.exists()) {
            System.out.println("File exists.");
            if (file.isDirectory()) {
                System.out.println("It is a directory.");
            } else {
                System.out.println("It is a regular file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    public static void AuthFailure() {
        // This method is responsible for handling authentication failures
        // For this example, let's assume a simple authentication process where a user is prompted to input a username and password

        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        // Here we are using a placeholder for authentication. In a real-world scenario, you would use a secure way of comparing passwords
        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}