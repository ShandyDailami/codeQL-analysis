import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_29422_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get("."); // Start scanning from the current directory
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path path : directoryStream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println(path);
                System.out.println("Creation time: " + attributes.creationTime());
                System.out.println("Last modified: " + attributes.lastModifiedTime());
                System.out.println("Size: " + attributes.size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}