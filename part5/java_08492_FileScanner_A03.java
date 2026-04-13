import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;

public class java_08492_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        FileSystems.getDefault().newWatchService();

        // Create a path for the directory we want to watch
        Path dir = FileSystems.getDefault().getPath(".");

        // Create a WatchService instance
        WatchService watcher = FileSystems.getDefault().newWatchService();

        // Register the directory to watch for changes
        dir.getFileSystem().walk(dir).forEach(p -> {
            p.getFileSystem().getWalker().followLinks(false);
            watcher.watch(p, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
        });

        // Start watching the directory for changes
        watcher.poll();

        // Print out the names of the files and directories
        // which are being watched at the moment
        for (WatchEvent<?> watchEvent : watcher.pollEvents()) {
            WatchEvent.Kind<?> kind = watchEvent.kind();

            // If the kind of event is ENTRY_MODIFY, then print out the name
            // of the file/directory which the event happened upon
            if (kind == StandardWatchEventKinds.ENTRY_MODIFY || kind == StandardWatchEventKinds.ENTRY_CREATE || kind == StandardWatchEventKinds.ENTRY_DELETE) {
                Path fileName = (Path) watchEvent.context();
                System.out.println("File: " + fileName);
            }
        }
    }
}