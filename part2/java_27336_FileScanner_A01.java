import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.nio.file.Files;

public class java_27336_FileScanner_A01 {

    public static void main(String[] args) throws Exception {
        FileSystems.getDefault().register(Files.newWatchService(), StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        Path startingPath = FileSystems.getDefault().getPath(".");
        scanDirectory(startingPath);
    }

    private static void scanDirectory(Path dir) {
        try {
            Files.newDirectoryStream(dir, "*.txt").forEach(FileScanner::processFile);

            Files.newDirectoryStream(dir, "*").forEach(FileScanner::scanDirectory);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid path", e);
        }
    }

    private static void processFile(Path file) {
        System.out.println("File: " + file.toString());
    }
}