import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_06147_FileScanner_A07 {
    public static void main(String[] args) {
        Path start = Paths.get(".").toAbsolutePath();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(start, "*.txt")) {
            for (Path path : directoryStream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println("File: " + path + " has size: " + attributes.size() + " bytes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}