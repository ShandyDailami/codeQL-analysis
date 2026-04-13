import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent;

public class java_34679_FileScanner_A01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length != 1) {
            System.out.println("Usage: java FileScanner <directory>");
            return;
        }

        Path dir = Paths.get(args[0]);
        WatchService watcher = FileSystems.getDefault().newWatchService();

        // Watch the directory for changes
        dir.getFileSystem().findAnyFiles(dir, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE)
        .subscribe(path -> processEvent(path));

        System.out.println("Watching " + dir + " for changes...");

        // Wait for changes
        boolean running = true;
        while (running) {
            WatchEvent<?> event = watcher.take();
            if (event.kind() == StandardWatchEventKinds.OVERFLOW) {
                System.err.println("WatchService dropped an event");
            } else if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                Path child = dir.resolve(event.context());
                if (child.getFileSystem() != dir.getFileSystem())
                    processEvent(child);
            } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                Path child = dir.resolve(event.context());
                if (child.getFileSystem() != dir.getFileSystem())
                    processEvent(child);
            } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                Path child = dir.resolve(event.context());
                if (child.getFileSystem() != dir.getFileSystem())
                    processEvent(child);
            }
        }
    }

    private static void processEvent(Path path) {
        try {
            System.out.println("Event: " + path.toString());
        } catch (Exception ex) {
            System.err.println("Exception: " + ex);
        }
    }
}