import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;

public class java_38747_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        FileSystems.getDefault().register(Paths.get("."),
                new java.nio.file.WatchService.盤(new Watcher() {
                    @Override
                    public void handle(WatchEvent<?> event) {
                        WatchEvent.Kind<?> eventKind = event.kind();

                        if (eventKind == StandardWatchEventKinds.ENTRY_CREATE) {
                            Path newFile = (Path) event.context();
                            System.out.println("New file: " + newFile);
                        }
                    }
                }));

        Thread.sleep(5000); // wait for 5 seconds

        FileSystems.getDefault().unregister(Paths.get("."));
    }
}