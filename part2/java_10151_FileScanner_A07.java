import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10151_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the current directory
        File currentDir = new File(".");

        // Prompt user for password file
        System.out.println("Please enter the password file:");
        Scanner scanner = new Scanner(System.in);
        String passwordFilePath = scanner.nextLine();

        // Read password file
        File passwordFile = new File(passwordFilePath);
        Scanner passwordScanner = new Scanner(passwordFile);
        String correctPassword = passwordScanner.nextLine();

        // Prompt user for password
        System.out.println("Please enter your password:");
        String userPassword = scanner.nextLine();

        // Authenticate user
        if (userPassword.equals(correctPassword)) {
            System.out.println("Access granted.");

            // Read files in current directory
            File[] files = currentDir.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("Access denied.");
        }

        // Close scanners
        passwordScanner.close();
        scanner.close();
    }
}