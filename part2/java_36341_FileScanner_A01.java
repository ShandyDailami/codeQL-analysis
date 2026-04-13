import java.nio.file.*;
import java.util.*;
import java.nio.charset.*;

public class java_36341_FileScanner_A01 {

    public static void main(String[] args) {
        Path file = Paths.get("./src/test.txt");
        try (Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8)) {
            lines.forEach(line -> {
                // Check if the line contains sensitive information related to A01_BrokenAccessControl
                if (line.contains("password") || line.contains("secret")) {
                    System.out.println("Security warning: line contains sensitive information");
                }
                // Otherwise, print the line
                else {
                    System.out.println(line);
                }
            });
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}