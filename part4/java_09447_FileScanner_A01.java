import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileSystem;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_09447_FileScanner_A01 {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with the directory you want to scan
        String fileExtension = "txt"; // Replace with the file extension you want to scan

        try (FileSystem fs = FileSystems.newFileSystem(Paths.get(directoryPath), null)) {
            WatchService watcher = fs.newWatchService();
            Path dir = fs.getPath(directoryPath);
            dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

            logger.log(Level.INFO, "Watching for file changes in: {0}", directoryPath);

            while (true) {
                WatchKey key = watcher.take();
                for (Path entry : key.pollEvents().keys()) {
                    if (entry.toString().endsWith("." + fileExtension)) {
                        logger.log(Level.INFO, "File change detected: {0}", entry);
                        // Add your code here to handle the file event
                    }
                }
                key.reset();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception caught", ex);
        }
    }
}