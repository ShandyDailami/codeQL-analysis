import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;

public class java_09911_FileScanner_A03 {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileSystems.getDefault().register(Paths.get("."), WatchEvent.Kind.ENTRY_CREATE, WatchEvent.Kind.ENTRY_DELETE, WatchEvent.Kind.ENTRY_MODIFY);

        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(".").normalize().toAbsolutePath();
        watchService.watch(path, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                Path filename = (Path) event.context();
                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    System.out.println("File created: " + filename);
                } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    System.out.println("File deleted: " + filename);
                } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.println("File modified: " + filename);
                }
            }
            key.reset();
        }
    }
}