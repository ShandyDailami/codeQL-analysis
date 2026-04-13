import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21610_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/credentials.txt"));
            String username = scanner.next();
            String password = scanner.next();
            System.out.println("Logging in with username: " + username + " and password: " + password);
        } catch (FileNotFoundException e) {
            System.out.println("Credentials file not found!");
        }
    }
}