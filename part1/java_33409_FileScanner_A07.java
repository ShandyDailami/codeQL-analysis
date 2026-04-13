import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_33409_FileScanner_A07 {

    private static final List<String> AUTHENTICATED_USERS = new ArrayList<>();

    static {
        AUTHENTICATED_USERS.add("user1");
        AUTHENTICATED_USERS.add("user2");
        // Add more users if needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        if (isAuthenticated(username)) {
            try {
                FileScanner fileScanner = new FileScanner(new File("."));
                fileScanner.scan(".*\\.java$", true);
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Authentication failed.");
        }

        scanner.close();
    }

    private static boolean isAuthenticated(String username) {
        return AUTHENTICATED_USERS.contains(username);
    }
}