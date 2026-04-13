import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_12982_FileScanner_A07 {

    private static final String AUTH_FILE = "auth.txt";

    public static void main(String[] args) {
        Map<String, String> users = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(AUTH_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] pair = line.split(":");
                users.put(pair[0], pair[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Assume we are trying to authenticate a username and a password
            String username = "user1";
            String password = "pass1";

            // We can assume the users in the auth file are hashed and saved in the users map.
            // This is a very simple example and does not actually authenticate the users.
            if (users.containsKey(username) && users.get(username).equals(password)) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}