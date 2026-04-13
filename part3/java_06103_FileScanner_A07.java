import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_06103_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get("./src/main/resources");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path)) {
            for (Path dir : dirs) {
                processDirectory(dir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processDirectory(Path dir) {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir)) {
            for (Path file : files) {
                if (Files.isDirectory(file)) {
                    System.out.println("Directory: " + file.toString());
                    processDirectory(file);
                } else {
                    System.out.println("File: " + file.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}