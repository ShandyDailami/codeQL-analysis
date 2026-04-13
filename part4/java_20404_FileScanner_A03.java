import java.io.File;
import java.util.Scanner;

public class java_20404_FileScanner_A03 {
    private static final String DIRECTORY = "path_to_your_directory"; // replace with your directory
    private static final String EXTENSION = "txt"; // replace with your extension

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the username: ");
        String username = scanner.nextLine();

        // Security sensitive operation to prevent injection attacks
        if (isUsernameValid(username)) {
            File file = new File(directory, username + "." + EXTENSION);

            if (file.exists()) {
                System.out.println("File found: " + file.getAbsolutePath());
            } else {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("Invalid username. Username must contain only alphanumeric characters and underscores.");
        }
    }

    private static boolean isUsernameValid(String username) {
        return username.matches("^[a-zA-Z0-9_]+$");
    }
}