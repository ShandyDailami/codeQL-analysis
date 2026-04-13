import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_01893_FileScanner_A07 {

    public static void main(String[] args) {
        Path start = Paths.get("path/to/directory/");
        try (DirectoryStream<Path> files = Files.newDirectoryStream(start)) {
            for (Path path : files) {
                if (Files.isRegularFile(path)) {
                    System.out.println("File: " + path.toString());
                    // Security-sensitive operation related to file deletion
                    try {
                        Files.delete(path);
                        System.out.println("Deleted file: " + path.toString());
                    } catch (IOException e) {
                        System.out.println("Failed to delete file: " + path.toString());
                   
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read directory: " + start.toString());
        }
    }
}