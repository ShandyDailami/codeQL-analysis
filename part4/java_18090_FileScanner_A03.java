import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class java_18090_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path

        Path path = Paths.get(directoryPath);
        try (Stream<Path> paths = Files.newFileWalk(path)) {
            paths.forEach(Main::printFileOrDirectoryName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFileOrDirectoryName(Path path) {
        if (Files.isDirectory(path, LinkOption.NOFOLLOW_SYMLINKS)) {
            System.out.println("Directory: " + path.toString());
        } else {
            System.out.println("File: " + path.toString());
        }
    }
}