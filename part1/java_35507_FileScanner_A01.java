import java.nio.file.*;

public class java_35507_FileScanner_A01 {
    public static void main(String[] args) {
        // Get the current directory
        Path currentDir = Paths.get(".");

        // Use the Files.newDirectoryStream method to get a directory stream
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(currentDir, ".*\\.txt")) {
            for (Path path : dirStream) {
                // If it is a file, print out its name
                if (Files.isRegularFile(path)) {
                    System.out.println(path.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}