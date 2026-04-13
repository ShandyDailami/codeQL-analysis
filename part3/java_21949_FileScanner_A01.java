import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class java_21949_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        // Get the current directory
        Path currentDir = Paths.get(".");

        // Use a try-with-resources statement to automatically close the directory stream
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(currentDir, "*.txt")) {
            for (Path path : dirStream) {
                // Print the file's path
                System.out.println("File: " + path.toString());

                // Read the file
                byte[] encoded = Files.readAllBytes(path);

                // Decode the bytes to a string
                String str = new String(encoded, StandardCharsets.UTF_8);
                System.out.println("Decoded string: " + str);
            }
        }

        // Check the file system type
        if (Files.getFileStore(currentDir).type().equals("posix")) {
            System.out.println("The file system is POSIX-compliant.");
        } else if (Files.getFileStore(currentDir).type().equals("windows")) {
            System.out.println("The file system is Windows-compliant.");
        } else {
            System.out.println("The file system is not POSIX or Windows-compliant.");
        }

        // Check if the current directory is a symbolic link
        if (Files.isSymbolicLink(currentDir)) {
            System.out.println("The current directory is a symbolic link.");
        } else {
            System.out.println("The current directory is not a symbolic link.");
        }
    }
}