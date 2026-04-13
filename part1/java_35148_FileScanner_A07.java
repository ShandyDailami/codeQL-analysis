import java.nio.file.*;
import java.util.stream.*;

public class java_35148_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.*");
        try (Stream<Path> paths = Files.list(Paths.get("."))) {
            paths.filter(matcher::matches)
                .forEach(FileScanner::printPathDetails);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printPathDetails(Path path) {
        try {
            if (Files.isDirectory(path)) {
                System.out.println(path + "/: directory");
            } else if (Files.isReadable(path)) {
                System.out.println(path + "/: readable file");
            } else {
                System.out.println(path + "/: other kind of file");
            }
        } catch (Exception ex) {
            System.out.println(path + "/: error reading file");
        }
    }
}