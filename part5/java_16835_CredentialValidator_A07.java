import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class java_16835_CredentialValidator_A07 {

    // Hard-coded credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out, true);

        writer.println("Please enter your username:");
        String userInput = reader.readLine();

        writer.println("Please enter your password:");
        String passwordInput = reader.readLine();

        if (userInput.equals(USERNAME) && passwordInput.equals(PASSWORD)) {
            writer.println("Login successful!");
        } else {
            writer.println("Login failed!");
        }
    }
}