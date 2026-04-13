import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class java_00211_FileScanner_A01 {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        File file = new File(userDir);

        FilenameFilter filter = (dir, name) -> name.endsWith(".txt");

        try {
            Files.walkFileTree(Paths.get(userDir), filter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}