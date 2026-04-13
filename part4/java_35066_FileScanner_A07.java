import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;

public class java_35066_FileScanner_A07 {
    public static void main(String[] args) throws Exception {
        FileSystems.getDefault().register(
            Path.of("./testDir"),
            new StandardWatchEventChannel(),
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_MODIFY,
            StandardWatchEventKinds.ENTRY_DELETE
        );

        WatchService watchService = FileSystems.getDefault().newWatchService();
        watchService.watch(Path.of("./testDir"), StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        while(true) {
            WatchEvent<?> watchEvent = watchService.take();
            WatchEvent.Kind<?> kind = watchEvent.kind();

            if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                Path path = ((WatchEvent<Path>) watchEvent).context();
                System.out.println("File created: " + path);
            }

            if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                Path path = ((WatchEvent<Path>) watchEvent).context();
                System.out.println("File modified: " + path);
            }

            if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                Path path = ((WatchEvent<Path>) watchEvent).context();
                System.out.println("File deleted: " + path);
            }
        }
    }
}