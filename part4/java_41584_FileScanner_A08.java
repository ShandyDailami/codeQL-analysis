import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;

public class java_41584_FileScanner_A08 {
    public static void main(String[] args) throws Exception {
        FileSystems.getDefault().register(
                Path.of("."),
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);

        WatchService watchService = FileSystems.getDefault().newWatchService();
        watchService.select(Path.of("."),
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);

        while (true) {
            Path eventPath = (Path) watchService.take().watchEvent().path();
            File file = eventPath.toFile();
            if (file.isFile() && file.length() > 500) {
                System.out.println("File: " + file.getAbsolutePath() + " has a size of " + file.length() + " bytes");
            }
        }
    }
}