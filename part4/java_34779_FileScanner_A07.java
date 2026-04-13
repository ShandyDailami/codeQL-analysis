import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_34779_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get("authfail.txt");

        // Check if file exists
        if (Files.exists(path, LinkOption.NOFOLLOW_SYMLINKS)) {
            // Check if file is readable
            if (Files.isReadable(path, LinkOption.NOFOLLOW_SYMLINKS)) {
                try (Stream<String> lines = Files.lines(path)) {
                    lines.forEach(line -> System.out.println(line));
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            } else {
                System.out.println("File is not readable");
            }
        } else {
            System.out.println("File does not exist");
        }
    }
}