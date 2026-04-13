import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_18990_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryPath))) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path);
                } else {
                    System.out.println("File: " + path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}