import java.nio.file.*;

public class java_38017_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        Path dir = Paths.get("./src"); // Change to your directory path
        FileSystem fs = dir.getFileSystem();

        // Use a try-with-resources statement to automatically close the file system and directory stream
        try (DirectoryStream<Path> dirs = fs.newDirectoryStream(dir)) {
            for (Path path : dirs) {
                if (Files.isRegularFile(path)) {
                    System.out.println(path.toString());
                }
            }
        }
    }
}