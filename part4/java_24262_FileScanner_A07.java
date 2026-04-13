import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24262_FileScanner_A07 {

    // This is a simple file scanner. It reads a file and tries to log in with the provided username and password.
    // The program is designed to use standard libraries only.

    public static void main(String[] args) {

        // Creating a File object to specify the file to be scanned.
        File file = new File("A07_AuthFailure.txt");

        try (Scanner scanner = new Scanner(file)) {

            // Prompting the user to enter the username.
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            // Prompting the user to enter the password.
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            // Trying to login with the provided username and password.
            // The program is designed to use standard libraries only.
            // In a real-world scenario, this would be a more complex process.
            if (username.equals("admin") && password.equals("password")) {
                System.out.println("Login successful.");
            } else {
                System.out.println("Login failed.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}