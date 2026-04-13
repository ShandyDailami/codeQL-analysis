import java.nio.file.*;
import java.nio.file.attribute.*; BasicFileAttributes;
import java.util.concurrent.atomic.AtomicBoolean;

public class java_36614_FileScanner_A07 {

    private final Path directory;
    private final WatchService watchService;
    private final AtomicBoolean running = new AtomicBoolean(true);

    public java_36614_FileScanner_A07(Path directory) throws IOException {
        this.directory = Objects.requireNonNull(directory);
        this.watchService = FileSystems.newWatchService();
        directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
    }

    public void start() {
        new Thread(() -> {
            while (running.get()) {
                WatchKey key;
                try {
                    key = watchService.take();
                } catch (InterruptedException e) {
                    running.set(false);
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                        Path file = directory.resolve(Paths.get((String) event.context()));
                        System.out.println("File created: " + file);
                    }
                    if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                        Path file = directory.resolve(Paths.get((String) event.context()));
                        System.out.println("File modified: " + file);
                   
                    }
                    if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                        Path file = directory.resolve(Paths.get((String) event.context()));
                        System.out.println("File deleted: " + file);
                    }
                }

                key.reset();
            }
        }).start();
    }

    public void stop() {
        running.set(false);
    }
}