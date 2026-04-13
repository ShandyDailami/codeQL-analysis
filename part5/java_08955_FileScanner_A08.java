import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_08955_FileScanner_A08 {
    private static final String EXTENSION = ".txt";

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*." + EXTENSION);
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get("."), matcher)) {
            dirStream.forEach(file -> {
                try {
                    // For the purpose of this example, we'll just print the file name
                    System.out.println("Scanning file: " + file.toString());

                    // Security-sensitive operations related to A08_IntegrityFailure
                    // Here you'd perform integrity checks on the file, such as checking file permissions or hashing the contents

                } catch (IOException e) {
                    System.err.println("Error accessing file: " + file);
                }
            });
        } catch (IOException e) {
            System.err.println("Error accessing directory");
       
        }
    }
}