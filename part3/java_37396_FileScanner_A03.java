import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_37396_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        PathMatcher<WatchEvent> matcher = FileSystems.getDefault().getWatchService().matcher();

        WatchEvent.Kind<?> kind;
        while ((kind = matcher.nextEvent()) != null) {
            WatchEvent<Path> event = matcher.result();

            Path file = event.context();
            if (kind == WatchEvent.EventType.CREATE) {
                // Process file creation events
                System.out.println("File created: " + file);
            } else if (kind == WatchEvent.EventType.DELETE) {
                // Process file deletion events
                System.out.println("File deleted: " + file);
            }
        }
    }
}