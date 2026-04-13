import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;

public class java_30505_FileScanner_A07 {

    public static void main(String[] args) throws IOException, InterruptedException {

        Path startingDirectory = Paths.get(".").toAbsolutePath();

        WatchService watchService = FileSystems.getDefault().newWatchService();
        try {
            watchService.watch(startingDirectory, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        Path createdFile = ((WatchEvent<Path>) event).context();
                        System.out.println("Created file: " + createdFile);
                    }
                    if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                        Path modifiedFile = ((WatchEvent<Path>) event).context();
                        System.out.println("Modified file: " + modifiedFile);
                    }
                    if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                        Path deletedFile = ((WatchEvent<Path>) event).context();
                        System.out.println("Deleted file: " + deletedFile);
                    }
                }
                key.reset();
            }
        } finally {
            watchService.close();
        }
    }
}