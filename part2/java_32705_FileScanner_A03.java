import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_32705_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*");

        // Get a DirectoryStream to list files in a directory
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get("./src/main/java/"))) {
            for (Path path : dirs) {
                if (matcher.matches(path.getFileName())) {
                    BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    System.out.println(path.getFileName());
                }
            }
        }

        // Get a FileStream to list files in a file
        try (FileStream fileStream = new FileStream("./src/main/java/Main.java", StandardOpenOption.READ)) {
            for (int i = 0; i < fileStream.available(); i++) {
                System.out.print((char) fileStream.read());
            }
        }
    }
}