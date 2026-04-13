import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_25782_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingPath = Paths.get("src/main/resources/");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingPath, "*.txt")) {
            for (Path path : directoryStream) {
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                if (path.getFileName().toString().contains("A08_IntegrityFailure")) {
                    System.out.println(path.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}