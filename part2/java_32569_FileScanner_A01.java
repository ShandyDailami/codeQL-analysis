import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.util.concurrent.CountDownLatch;

public class java_32569_FileScanner_A01 {

    private static final String DIRECTORY_TO_SCAN = "/path/to/directory";
    private static final String FILE_TO_FIND = "file.txt";

    public static void main(String[] args) throws InterruptedException {

        FileSystems.newFileSystem(Paths.get(DIRECTORY_TO_SCAN), null).close();

        Path directory = Paths.get(DIRECTORY_TO_SCAN);
        WatchService watchService = directory.getFileSystem().newWatchService();
        directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        CountDownLatch latch = new CountDownLatch(1);
        watchService.poll(1, java.nio.channels.Channels.newChannel(System.out), result -> {
            if (result.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                Path path = directory.resolve(result.context());
                if (path.toString().endsWith(FILE_TO_FIND)) {
                    System.out.println("File found: " + path);
                    latch.countDown();
                }
            }
        });

        latch.await();
    }
}