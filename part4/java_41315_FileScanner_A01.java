import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_41315_FileScanner_A01 {
    public static void main(String[] args) {
        try (DirectoryStream<Path> directories = FileSystems.getDefault().getDirectoryStream(Paths.get("/path/to/directory"), ".*")) {
            for (Path directory : directories) {
                System.out.println(directory.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}