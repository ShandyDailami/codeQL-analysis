import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_24831_FileScanner_A03 {
    public static void main(String[] args) {
        Path startingDir = Paths.get(".");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDir, "*.{txt,log}")) {
            for (Path path : dirs) {
                FileAttributes attrs = Files.readAttributes(path, FileAttributes.class);
                if (attrs.isRegularFile()) {
                    System.out.println(path.toString());
                }
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}