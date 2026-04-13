import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class java_11718_FileScanner_A07 {
    private static final String HOME_DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
        String homeDir = HOME_DIR;
        String directoryPath = homeDir + "/src";
        FileScanner(directoryPath);
    }

    public static void FileScanner(String directoryPath) {
        try (Stream<Path> stream = Files.walk(Paths.get(directoryPath))) {
            stream.forEach(FileScanner::processFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path path) {
        if (Files.isRegularFile(path)) {
            System.out.println("File: " + path.toString());
        } else if (Files.isDirectory(path)) {
            System.out.println("Directory: " + path.toString());
        }
    }
}