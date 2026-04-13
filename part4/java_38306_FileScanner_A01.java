import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;

public class java_38306_FileScanner_A01 {

    public static void main(String[] args) throws Exception {
        FileSystems.getDefault().register(new SimpleFileListener(), ".");

        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = FileSystems.getDefault().getPath(".");
        watchService.watch(path, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        // Keep the main thread alive
        while (true) {
            WatchEvent<?> watchEvent = watchService.take();
            WatchEvent<Path> event = (WatchEvent<Path>) watchEvent;
            Path pathChanged = event.context();
            if (StandardWatchEventKinds.ENTRY_CREATE.equals(watchEvent.kind()) && "target".equals(pathChanged.toString())) {
                System.out.println("File created: " + pathChanged);
            } else if (StandardWatchEventKinds.ENTRY_MODIFY.equals(watchEvent.kind()) && "target".equals(pathChanged.toString())) {
                System.out.println("File modified: " + pathChanged);
            } else if (StandardWatchEventKinds.ENTRY_DELETE.equals(watchEvent.kind()) && "target".equals(pathChanged.toString())) {
                System.out.println("File deleted: " + pathChanged);
            }
        }
    }

    static class SimpleFileListener implements java.nio.file.WatchEventListener {
        @Override
        public void onEvent(WatchService watchService, WatchEvent<Path> event) {
            WatchEvent.Kind<?> eventKind = event.kind();
            Path path = event.context();

            if (StandardWatchEventKinds.ENTRY_CREATE.equals(eventKind)) {
                System.out.println("File created: " + path);
            } else if (StandardWatchEventKinds.ENTRY_MODIFY.equals(eventKind)) {
                System.out.println("File modified: " + path);
            } else if (StandardWatchEventKinds.ENTRY_DELETE.equals(eventKind)) {
                System.out.println("File deleted: " + path);
            }
        }
    }
}