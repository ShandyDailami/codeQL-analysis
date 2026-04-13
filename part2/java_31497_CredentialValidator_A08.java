import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_31497_CredentialValidator_A08 {

    // Loaded credentials from a file for simplicity
    private static Map<String, String> credentials = new HashMap<>();

    // Load credentials from a file
    static {
        try (BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                credentials.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        validateCredentials("admin", "admin"); // Password is "admin"
    }

    // Method to validate credentials
    public static boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Credentials validated successfully!");
            return true;
        } else {
            System.out.println("Credentials not valid!");
            return false;
        }
    }
}