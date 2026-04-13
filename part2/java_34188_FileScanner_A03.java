import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_34188_FileScanner_A03 {

    public static void main(String[] args) throws Exception {
        FileSystems.getDefault().register(Paths.get("/path/to/watch"), WatchEvent.Kind.ENTRY_CREATE, WatchEvent.Kind.ENTRY_MODIFY, WatchEvent.Kind.ENTRY_DELETE);

        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(() -> {
            while (true) {
                WatchEvent<Path> event = watchService.take();
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    File newFile = new File(event.context().toString());
                    System.out.println("File created: " + newFile.getAbsolutePath());
                } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    File modifiedFile = new File(event.context().toString());
                    System.out.println("File modified: " + modifiedFile.getAbsolutePath());
                } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                    File deletedFile = new File(event.context().toString());
                    System.out.println("File deleted: " + deletedFile.getAbsolutePath());
                }
            }
        });
    }

    private static WatchService watchService;

    static {
        try {
            watchService = FileSystems.getDefault().newWatchService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}