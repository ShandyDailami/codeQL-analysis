import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;

public class java_14393_FileScanner_A01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get(".");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        System.out.println("Watching " + path + " for changes...");

        while (true) {
            WatchKey key = watchService.take();

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    System.out.println("Created: " + path + "/" + event.context());
                }

                if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.println("Modified: " + path + "/" + event.context());
                }

                if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    System.out.println("Deleted: " + path + "/" + event.context());
                }
            }

            key.reset();
        }
    }
}