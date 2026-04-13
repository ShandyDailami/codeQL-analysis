import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34409_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            File file = new File("path_to_file"); // Replace with actual file path
            try {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        } else {
            System.out.println("Authentication failed!");
        }
    }

    private static boolean authenticateUser(String username, String password) {
        // Implement your authentication logic here.
        // For this example, we just check if the username and password are correct.
        return username.equals("admin") && password.equals("password");
    }
}