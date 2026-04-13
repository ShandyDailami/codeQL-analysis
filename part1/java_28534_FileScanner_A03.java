import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;

public class java_28534_FileScanner_A03 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Initialize FileSystems and Paths
        FileSystems fs = FileSystems.getDefault();
        Path dir = fs.getPath("C:\\Users\\your_directory_path");

        // Watch the directory for changes
        WatchService watchService = fs.newWatchService();
        dir.getFileSystem().setAttribute(Path.class, "a", watchService);
        dir.getFileSystem().getDefaultWatchService().watch(dir, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        // Print the paths of the changed files
        for (; ; ) {
            WatchService watch = fs.newWatchService();
            watch.info("watch " + dir + " " + watch);
            watch.set(dir, watchService);
            WatchKey key = watchService.take();
            for (Path event : key.pollEvents()) {
                if (event.getKind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    System.out.println("created: " + event.toString());
                }
                if (event.getKind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.println("modified: " + event.toString());
                }
                if (event.getKind() == StandardWatchEventKinds.ENTRY_DELETE) {
                    System.out.println("deleted: " + event.toString());
                }
            }
            key.reset();
        }
    }
}