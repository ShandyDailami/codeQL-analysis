import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_21843_FileScanner_A01 {
    private static final String DIRECTORY = "src/main/java";
    private static final String PATTERN = "*.java";

    public static void main(String[] args) {
        File root = new File(DIRECTORY);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        WatchService watchService = FileSystems.newFileWatchService();

        Path rootPath = FileSystems.newFileStore(root.toPath()).getRoot();
        watchService.watch(rootPath, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        executor.submit(() -> {
            while (true) {
                WatchKey key = watchService.poll(1, java.util.concurrent.TimeUnit.SECONDS);
                if (key != null) {
                    for (WatchEvent<?> event : key.pollEvents()) {
                        if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                            File file = new File(root, event.context().toString());
                            if (file.isFile() && file.getName().endsWith(PATTERN)) {
                                System.out.println("Created file: " + file.getAbsolutePath());
                            }
                        } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                            File file = new File(root, event.context().toString());
                            if (file.isFile() && file.getName().endsWith(PATTERN)) {
                                System.out.println("Modified file: " + file.getAbsolutePath());
                            }
                        } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                            File file = new File(root, event.context().toString());
                            if (file.isFile() && file.getName().endsWith(PATTERN)) {
                                System.out.println("Deleted file: " + file.getAbsolutePath());
                            }
                        }
                    }
                    key.reset();
                }
            }
        });
    }
}