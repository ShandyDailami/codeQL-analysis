import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.nio.file.PathMatcher;

public class java_34399_FileScanner_A01 {
    private final WatchService watchService;
    private final PathMatcher pathMatcher;

    public java_34399_FileScanner_A01(String directoryPath) {
        watchService = FileSystems.newWatchService();
        Path directory = FileSystems.newFileSystem(Path.of(directoryPath), null).getRoot();
        pathMatcher = directory.getFileSystem().getPathMatcher("glob:*.txt");
        directory.getFileSystem().getProvider().listen(directory, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        watch(directory);
    }

    private void watch(Path dir) {
        for (WatchEvent<?> event : dir.getFileSystem().getWatchService().pollEvents()) {
            if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                Path file = (Path) event.context();
                if (pathMatcher.matches(file)) {
                    System.out.println("File created: " + file);
                    // Perform security-sensitive operations related to Access Control (A01_BrokenAccessControl)
                }
            } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                Path file = (Path) event.context();
                if (pathMatcher.matches(file)) {
                    System.out.println("File modified: " + file);
                    // Perform security-sensitive operations related to Access Control (A01_BrokenAccessControl)
                }
            } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                Path file = (Path) event.context();
                if (pathMatcher.matches(file)) {
                    System.out.println("File deleted: " + file);
                    // Perform security-sensitive operations related to Access Control (A01_BrokenAccessControl)
                }
            }
        }

        try {
            watchService.take().reset();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        watch(dir);
    }
}