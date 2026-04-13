import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26850_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("password.txt"));
            String password = scanner.nextLine();

            // Assume the user enters the correct password
            if (password.equals("correctpassword")) {
                System.out.println("Access granted!");
            } else {
                System.out.println("Access denied!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Password file not found.");
        }
    }
}