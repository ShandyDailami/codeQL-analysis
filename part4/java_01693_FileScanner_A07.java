import java.nio.file.*;
import java.util.*;

public class java_01693_FileScanner_A07 {
    private static final String AUTHORIZED_USER = "admin";
    private static final String AUTHORIZATION_FILE = "auth.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        if (username.equals(AUTHORIZED_USER)) {
            System.out.println("Authorized user, reading files...");
            readFiles(Paths.get("."));
        } else {
            System.out.println("Authentication failed. Cannot read files.");
        }
    }

    private static void readFiles(Path dir) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.txt")) {
            for (Path file : stream) {
                System.out.println("Reading file: " + file.toString());
                Files.lines(file).forEach(System.out::println);
            }
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
}