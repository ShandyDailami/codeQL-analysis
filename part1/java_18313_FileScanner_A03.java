import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_18313_FileScanner_A03 {

    public static void main(String[] args) throws IOException, InterruptedException {

        File file = new File(".");
        Path path = Paths.get(".");

        // Create a WatchService.
        WatchService watchService = FileSystems.newWatchService();

        // Register the WatchService with the File
        file.getFileSystem().newServer().setWatchService(watchService);

        // Register the directory to watch.
        Files.walkFileTree(path, EnumSet.of(StandardFileAttributes.Decrypted),
                new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        watchService.watch(file, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
                                StandardWatchEventKinds.ENTRY_DELETE);
                        return FileVisitResult.CONTINUE;
                    }
                });

        // Create an ExecutorService for multithreaded file monitoring.
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            while (true) {
                WatchKey key;
                try {
                    key = watchService.take();
                } catch (InterruptedException e) {
                    return;
                }

                // Process events.
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    // Stop if the directory is closed.
                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        return;
                    }

                    // Process the event.
                    Path name = (Path) event.context();
                    System.out.printf("Watch event: %s %s\n", event.kind(), name);
                }

                // Reset the key.
                key.reset();
            }
        });
    }
}