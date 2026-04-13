import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

public class java_01864_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("src/main/java");
        try (Stream<Path> paths = Files.walk(dir)) {
            paths.forEach(FileScanner::printFileDetails);
        }
    }

    private static void printFileDetails(Path path) throws IOException {
        if (Files.isRegularFile(path)) {
            System.out.println("File: " + path.getFileName());
            System.out.println("Size: " + Files.size(path) + " bytes");
            System.out.println("Creation time: " +
                    LocalDateTime.ofInstant(Files.getLastModifiedTime(path).toInstant(), ZoneId.systemDefault()));
        }
    }
}