import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;

public class java_13430_FileScanner_A08 {

    private static final String DIRECTORY_TO_SCAN = "/path/to/directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_TO_SCAN);
        try {
            Files.walkFileTree(directory.toPath(), new SimpleFileVisitor<>(), 1, FileVisitOption.FOLLOW_LINKS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}