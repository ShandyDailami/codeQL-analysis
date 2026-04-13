import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_24945_FileScanner_A01 {

    private static final String DIRECTORY_PATH = "/path/to/directory";
    private static final String SECRET_KEY = "This is a secret key";
    private static final String SENSITIVE_FILE_EXTENSION = ".svc";

    private BlockingQueue<Path> queue = new LinkedBlockingQueue<>();
    private WatchService watchService;

    public java_24945_FileScanner_A01() {
        try {
            watchService = FileSystems.newWatchService();
            File directory = new File(DIRECTORY_PATH);
            directory.mkdirs(); // create directory if not exists
            queue.put(directory.toPath());
            watchService.watch(
                    directory,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE
            );
            Thread thread = new Thread(() -> {
                try {
                    while (true) {
                        Path path = queue.take();
                        File file = path.toFile();
                        if (file.isFile() && file.getName().endsWith(SENSITIVE_FILE_EXTENSION)) {
                            // read file content
                            String content = new String(java.nio.file.Files.readAllBytes(path));
                            // check if content contains secret key
                            if (content.contains(SECRET_KEY)) {
                                System.out.println("Access attempt detected in file: " + file.getAbsolutePath());
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}