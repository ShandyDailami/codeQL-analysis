import java.nio.file.*;
import java.io.*;

public class java_05191_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath(); // current directory
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.java");

        try (DirectoryStream<Path> directories = Files.newDirectoryStream(startingDirectory, "glob:**.java")) {
            for (Path path : directories) {
                if (Files.exists(path)) {
                    System.out.println("File: " + path.toString());
                }
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}