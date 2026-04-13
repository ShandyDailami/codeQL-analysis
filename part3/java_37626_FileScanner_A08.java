import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_37626_FileScanner_A08 {
    private static final String DIRECTORY_PATH = "path_to_directory"; // replace with your directory path
    private static final String[] FILE_EXTENSIONS = { ".txt", ".java" }; // replace with your file extensions

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your password:");
        String password = scanner.nextLine(); // scanner.nextLine() is used to capture password input

        if (isPasswordCorrect(password)) {
            File[] files = directory.listFiles((dir, name) -> Arrays.stream(FILE_EXTENSIONS).anyMatch(ext -> name.endsWith(ext)));

            if (files != null) {
                Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
            } else {
                System.out.println("No files found with the given extensions.");
            }
        } else {
            System.out.println("Incorrect password.");
        }

        scanner.close();
    }

    private static boolean isPasswordCorrect(String password) {
        // Implement your own logic to check the password
        // This example just checks if the password is "password"
        return password.equals("password");
    }
}