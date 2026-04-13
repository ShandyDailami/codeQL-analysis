import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31076_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("credentials.txt"));
            while (scanner.hasNext()) {
                String username = scanner.next();
                String password = scanner.next();
                // Now perform authentication here with the credentials and handle the result.
                // You will need to implement the authentication mechanism yourself.
                // For the purpose of this example, we just print the credentials.
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}