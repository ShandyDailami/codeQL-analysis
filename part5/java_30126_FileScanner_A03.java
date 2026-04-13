import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_30126_FileScanner_A03 {
    public static void main(String[] args) {
        Path startingDir = Paths.get(".");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDir,
                path -> String.valueOf(path).endsWith(".txt")) {
            for (Path path : directoryStream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println("Reading file: " + path.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}