import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_02150_FileScanner_A07 {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Path startPath = Paths.get("path_to_directory");
        String passwordFile = "password_file";

        // Load password
        Stream<String> passwordStream;
        if (Files.exists(Paths.get(passwordFile))) {
            passwordStream = Files.lines(Paths.get(passwordFile));
        } else {
            System.out.println("Password file not found, use blank password");
            passwordStream = Stream.of("");
        }
        String password = passwordStream.findFirst().orElse(null);

        try (Stream<String> lines = Files.lines(startPath)) {
            lines.forEach(line -> {
                String filePath = line.trim();
                try {
                    // Authenticate
                    if (authenticate(filePath, username, password)) {
                        Files.copy(Paths.get(filePath), Paths.get(filePath + "_new"));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String filePath, String username, String password) {
        // Authenticate using username and password
        // This is a simple implementation, you may want to use a secure method
        // and handle credentials correctly.
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}