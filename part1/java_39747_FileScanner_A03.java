import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;

public class java_39747_FileScanner_A03 {
    private final WatchService watchService;
    private final Path startingPath;

    public java_39747_FileScanner_A03(String startingPath, String fileExtension) throws Exception {
        this.startingPath = Paths.get(startingPath);
        watchService = WatchService.createWatchService();

        recursiveWatch(startingPath, fileExtension);
    }

    private void recursiveWatch(Path path, String fileExtension) throws Exception {
        Files.walk(path)
            .filter(Files::isRegularFile)
            .filter(file -> file.toString().endsWith(fileExtension))
            .forEach(file -> watchService.watch(file,
                StandardWatchEventKinds.ENTRY_MODIFIED,
                StandardWatchEventKinds.ENTRY_DELETED));

        Files.list(path)
            .filter(Files::isDirectory)
            .forEach(dir -> recursiveWatch(dir, fileExtension));
    }

    public void awaitChanges() {
        try {
            watchService.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}