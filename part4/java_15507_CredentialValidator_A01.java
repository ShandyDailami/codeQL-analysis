import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_15507_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_15507_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        loadCredentials();
    }

    private void loadCredentials() {
        try (BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    this.credentials.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isValid(String username, String password) {
        return this.credentials.containsKey(username) &&
                this.credentials.get(username).equals(password);
    }
}