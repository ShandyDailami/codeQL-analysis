import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;

public class java_38692_FileScanner_A01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        PathMatcher<Path> matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");

        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path dir = Paths.get("/path/to/watch");
        dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<Path> event : key.pollEvents().asList()) {
                Path moved = event.context();
                if (matcher.matches(moved)) {
                    System.out.println("File " + moved + " has been " + event.kind() + "d.");
                } else {
                    System.out.println("File " + moved + " was not matched by our criteria.");
                }
            }
            key.reset();
        }
    }
}