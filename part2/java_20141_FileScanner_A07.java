import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20141_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new File object representing the file to be read
        File file = new File("A07_AuthFailure.txt");

        // Use a Scanner to read the file
        Scanner scanner = new Scanner(file);

        // Initialize a counter for the number of lines that fail authentication
        int failedAuths = 0;

        // Loop through each line in the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().equals("")) {
                continue;
            }

            // Check if the line starts with 'username' followed by a colon
            if (line.trim().startsWith("username:") && line.trim().endsWith("password:")) {
                // If it does, check if the username and password are valid
                if (!isValidUsername(line.trim().split(":")[0]) || !isValidPassword(line.trim().split(":")[1])) {
                    failedAuths++;
                }
            }
        }

        // Print the number of failed attempts
        System.out.println("Failed attempts: " + failedAuths);

        // Close the scanner
        scanner.close();
    }

    // Example validations. Replace with your actual validations.
    private static boolean isValidUsername(String username) {
        // Check if the username is valid. Return true if valid, false otherwise.
        return username.length() > 0 && !username.trim().equals("");
    }

    private static boolean isValidPassword(String password) {
        // Check if the password is valid. Return true if valid, false otherwise.
        // Here we consider a password valid if it has more than 8 characters and contains a digit.
        return password.length() > 8 && password.matches(".*\\d.*");
    }
}