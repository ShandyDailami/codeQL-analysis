import java.io.File;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_39577_FileScanner_A01 {
    private static final String DIRECTORY_TO_SCAN = "/path/to/directory"; // specify your directory
    private static final int NUM_THREADS = 4; // adjust this based on your system's capacity

    public static void main(String[] args) throws Exception {
        File directory = new File(DIRECTORY_TO_SCAN);

        // Create a new executor service with NUM_THREADS threads.
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        // Create a WatchService and register a directory to monitor.
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Paths.get(directory.toPath()).register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        // Monitor the directory for changes.
        while (true) {
            watchService.poll(1, java.nio.channels.Selector.OP_READ).stream().forEach(event -> {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE || event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    Path filePath = (Path) event.context();
                    executorService.submit(() -> {
                        try {
                            File file = filePath.toFile();
                            if (file.isFile() && !file.isHidden()) {
                                System.out.println("File " + file.getAbsolutePath() + " has been modified.");
                                // Add your file processing code here.
                            }
                        } catch (Exception e) {
                            System.err.println("An error occurred while processing the file.");
                            e.printStackTrace();
                        }
                    });
                }
            });
        }
    }
}