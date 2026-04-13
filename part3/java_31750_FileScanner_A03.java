import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_31750_FileScanner_A03 {

    private static final BlockingQueue<WatchEvent<Path>> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws Exception {
        Path start = Paths.get(".");

        if (args.length == 1) {
            start = Paths.get(args[0]);
        }

        Thread thread = new Thread(new Watcher(queue));
        thread.start();

        try {
            start(start);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            thread.interrupt();
        }
    }

    private static void start(Path start) throws Exception {
        FileSystems.newFileSystem(start, null);

        for (final Path path : FileSystems.getDefault().newDirectoryStream(start, ".*")) {
            if (path.toString().endsWith(File.separator)) {
                start(path);
            } else {
                System.out.println(path.toString());
            }
        }
    }

    static class Watcher implements Runnable {
        private final WatchService watchService;

        Watcher(BlockingQueue<WatchEvent<Path>> queue) {
            this.watchService = WatchService.newDefault();

            Paths.get(".").register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        }

        @Override
        public void run() {
            try {
                WatchEvent<Path> event;
                while ((event = queue.poll()) != null) {
                    System.out.printf("event: %s path1: %s path2: %s\n", event.kind(), event.context1(), event.context2());
                }
            } finally {
                watchService.close();
            }
        }
    }
}