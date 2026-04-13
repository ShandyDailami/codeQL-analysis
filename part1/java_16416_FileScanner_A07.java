import java.nio.file.*;

public class java_16416_FileScanner_A07 {
    public static void main(String[] args) {
        // Set up a PathMatcher to match directories with a "glob" pattern
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/A07_AuthFailure/**");

        // Get a file system
        FileSystem fs = FileSystems.getDefault();

        // Get the root directory
        Path root = fs.getRootDirectories().iterator().next();

        // Scan the root directory
        try (DirectoryStream<Path> stream = fs.getDirectoryStream(root, matcher)) {
            for (Path path : stream) {
                // Check if the path is a directory
                if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                    try (DirectoryStream<Path> subStream = fs.newDirectoryStream(path)) {
                        for (Path subPath : subStream) {
                            // Check if the sub-path is a file
                            if (Files.isRegularFile(subPath, LinkOption.NOFOLLOW_LINKS)) {
                                // Process the file
                                System.out.println("Processing file: " + subPath);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}