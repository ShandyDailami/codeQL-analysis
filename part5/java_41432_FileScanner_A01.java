import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_41432_FileScanner_A01 {

    private static final PathMatcher<? super Path> FILE_FILETERM = FileSystems.newFileSystem(Paths.get("."), java.nio.file.StandardOSPrincipal.currentSystemUser());

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String extension = ".txt";

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : dirs) {
                if (FILE_FILETERM.matches(path)) {
                    BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    if (Files.isRegularFile(path) && path.toString().endsWith(extension)) {
                        System.out.println(path.toString());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}