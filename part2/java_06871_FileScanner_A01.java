import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;

public class java_06871_FileScanner_A01 {
    private final WatchService watchService;
    private final Path startingDirectory;

    public java_06871_FileScanner_A01(Path startingDirectory) throws IOException {
        this.startingDirectory = startingDirectory;
        watchService = FileSystems.newFileSystem(startingDirectory, null);
    }

    public void startWatching() throws IOException, InterruptedException {
        watchService.watch(startingDirectory, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
        while (true) {
            WatchEvent<?> event = watchService.take();
            WatchEvent<Path> pathEvent = (WatchEvent<Path>) event;
            Path filename = pathEvent.context();
            System.out.println("File " + filename + " has been " + pathEvent.kind().name().toLowerCase() + "ed.");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        FileScanner scanner = new FileScanner(Paths.get("/path/to/directory"));
        scanner.startWatching();
    }
}