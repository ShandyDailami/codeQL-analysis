import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.util.logging.Logger;

public class java_33333_FileScanner_A03 {
    private static final Logger logger = Logger.getLogger(FileScanner.class.getName());

    public static void main(String[] args) throws Exception {
        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path startPath = Paths.get(".");
        watchDirectory(watchService, startPath);

        watchService.take().get();
    }

    private static void watchDirectory(WatchService watchService, Path path) throws Exception {
        logger.info("Watching " + path);

        Files.walk(path)
            .filter(Files::isRegularFile)
            .map(Path::toFile)
            .forEach(file -> watchService.watch(file.toPath(), StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE));

        watchService.watch(path, StandardWatchEventKinds.ENTRY_DELETE);

        WatchKey key = watchService.take();
        for (WatchEvent<?> event : key.pollEvents()) {
            WatchEvent.Kind<?> kind = event.kind();

            if (kind == StandardWatchEventKinds.OVERFLOW) {
                logger.warning("WatchService overflowed: " + kind);
            } else {
                Path filePath = (Path) event.context();
                logger.info("File " + filePath + " " + kind + " event");
            }
        }

        logger.info("Stopped watching " + path);

        key.reset();
    }
}