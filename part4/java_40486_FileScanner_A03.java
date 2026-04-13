import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;

public class java_40486_FileScanner_A03 {

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path path = Paths.get("./"); // replace with your directory path
        watchService.watch(path, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        System.out.println("Watching for changes...");

        while (true) {
            WatchEvent<?> event = watchService.take();

            WatchEvent.Kind<?> kind = event.kind();

            if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                Path newFile = (Path) event.context();
                System.out.println("Created: " + newFile.toString());
            } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                Path modifiedFile = (Path) event.context();
                System.out.println("Modified: " + modifiedFile.toString());
            } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                Path deletedFile = (Path) event.context();
                System.out.println("Deleted: " + deletedFile.toString());
            }
        }
    }
}