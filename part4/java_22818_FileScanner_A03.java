import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_22818_FileScanner_A03 {

    private static final String[] KNOWN_PASSWORDS = {"password", "secret", "admin"};

    public static void main(String[] args) throws IOException {
        File file = new File("path_to_your_file");

        // Use Files.lines to read the file line by line
        try (Stream<String> lines = Files.lines(Paths.get(file.toPath()))) {
            lines.forEach(line -> {
                if (lineMatchesKnownPassword(line)) {
                    System.out.println("Warning: Potential password found in file: " + file.getPath());
                }
            });
        }
    }

    private static boolean lineMatchesKnownPassword(String line) {
        for (String password : KNOWN_PASSWORDS) {
            if (line.contains(password)) {
                System.out.println("Password found in line: " + line);
                return true;
            }
        }
        return false;
    }
}