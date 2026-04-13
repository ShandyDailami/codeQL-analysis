import java.io.*;
import java.nio.file.*;
import java.security.*;

public class java_34424_FileScanner_A07 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("/path/to/dir");

        try (Stream<Path> stream = Files.walk(path)) {
            for (Path p : stream.collect(Collectors.toList())) {
                if (Files.isDirectory(p)) {
                    continue;
                }

                byte[] fileContent = Files.readAllBytes(p);

                // Use a MessageDigest for security-sensitive operations
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] digest = md.digest(fileContent);

                // Check if the file content is altered
                if (checkIfAltered(digest)) {
                    System.out.println("File content altered: " + p);
                }
            }
        }
    }

    private static boolean checkIfAltered(byte[] digest) {
        // Implement your own security-related operations here
        // This is just a placeholder
        return false;
    }
}