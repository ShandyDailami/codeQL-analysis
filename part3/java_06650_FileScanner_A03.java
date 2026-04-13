import java.nio.file.*;
import java.util.*;
import java.nio.file.attribute.*;

public class java_06650_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Specify your directory path here

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(directoryPath))) {
            for (Path path : dirStream) {
                if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
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