import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_13483_FileScanner_A01 {
    public static void main(String[] args) {
        Path start = Paths.get("."); // Start at the current directory

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(start)) {
            for (Path path : dirs) {
                System.out.println(path.toString());
           
                try (DirectoryStream<Path> subdirs = Files.newDirectoryStream(path)) {
                    for (Path subpath : subdirs) {
                        System.out.println("    " + subpath);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not list directory contents.");
        }
    }
}