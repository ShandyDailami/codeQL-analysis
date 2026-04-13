import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;

public class java_21070_FileScanner_A08 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path directory = Paths.get("./");

        WatchService watchService = FileSystems.newFileSystem(directory.getParent().get(), null).newWatchService();

        directory.getFileSystem().getRootDirectories().forEach(path -> watchService.watch(path, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE));

        while (true) {
            WatchEvent<Path> watchEvent = watchService.take();

            Path eventPath = watchEvent.context();
            WatchEvent.Kind<?> eventKind = watchEvent.kind();

            if (eventKind == StandardWatchEventKinds.ENTRY_CREATE) {
                System.out.println("File created: " + eventPath.toString());
            } else if (eventKind == StandardWatchEventKinds.ENTRY_MODIFY) {
                System.out.println("File modified: " + eventPath.toString());
            } else if (eventKind == StandardWatchEventKinds.ENTRY_DELETE) {
                System.out.println("File deleted: " + eventPath.toString());
            }
        }
    }
}