import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_29104_FileScanner_A03 {

    private static final String DIRECTORY_TO_SCAN = "/path/to/directory"; // replace with your directory

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        File file = new File(DIRECTORY_TO_SCAN);
        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path path = Paths.get(DIRECTORY_TO_SCAN);
        watchService.watch(path, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        System.out.println("Watching for changes in " + DIRECTORY_TO_SCAN + "...");

        while (true) {
            WatchKey watchKey = watchService.take();
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                Path changed = (Path) event.context();
                System.out.println("File " + changed + " has been " + event.kind() + "ed.");
                executor.submit(() -> {
                    // TODO: add code to handle the file change event
                });
            }
            watchKey.reset();
        }
    }
}