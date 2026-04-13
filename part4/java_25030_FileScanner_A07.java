import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class java_25030_FileScanner_A07 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // specify your directory

        try (Stream<Path> paths = FileSystems.getDefault().getRootDirectories().flatMap(SecureFileScanner::getFiles)) {
            paths.filter(file -> Files.isReadable(file)).forEach(file -> {
                try {
                    File originalFile = file.toFile();
                    String content = new String(Files.readAllBytes(file));

                    // perform security-sensitive operations on file content
                    // for example, replace passwords with asterisks
                    String secureContent = content.replace("password", "********");

                    // write the secure content back to file
                    Files.write(file, secureContent.getBytes(), StandardOpenOption.WRITE);
                } catch (Exception ex) {
                    // handle exceptions
                }
            });
        } catch (Exception ex) {
            // handle exceptions
        }
    }

    private static Stream<Path> getFiles(String dir) {
        try {
            return Files.newDirectoryStream(Paths.get(dir));
        } catch (Exception ex) {
            return Stream.empty();
        }
    }
}