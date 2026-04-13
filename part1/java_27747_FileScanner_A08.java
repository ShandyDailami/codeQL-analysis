import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;

public class java_27747_FileScanner_A08 {
    public static void main(String[] args) throws Exception {
        FileSystems.getDefault().register(Paths.get("."), WatchService watcher = FileSystems.getDefault().newWatchService());

        Path initialPath = Paths.get(".");
        watch(initialPath, watcher);

        watcher.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    private static void watch(Path path, WatchService watcher) throws InterruptedException {
        for (Path p : path.iterable()) {
            if (Files.isDirectory(p, LinkOption.NOFOLLOW_LINKS)) {
                watch(p, watcher);
            }

            WatchEvent<Path> event = watcher.take();
            if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE || event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                System.out.println("Modified file: " + p.toString());
            }
        }
    }
}