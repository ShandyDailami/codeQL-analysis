import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_05258_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("/path/to/your/directory"), matcher)) {
            for (Path path : directoryStream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);

                if (attributes.isReadable() && attributes.isWritable()) {
                    System.out.println("File is readable and writable: " + path);
                }
           
                // Add your security-sensitive operations here
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}