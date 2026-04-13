import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class java_03770_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            // Create a FileScanner instance.
            FileScanner scanner = new FileScanner();

            // Specify the directory to scan.
            File directory = new File("src/main/java/");

            // Start scanning the directory.
            scanner.scanDirectory(directory);

            // Print out the found files.
            for (Path file : scanner.getFoundFiles()) {
                System.out.println("Found file: " + file);
            }

            // Print out the events that occurred.
            for (FileEvent event : scanner.getFileEvents()) {
                System.out.println("Event: " + event);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class FileScanner {
        private Path[] foundFiles = new Path[0];
        private FileEvent[] fileEvents = new FileEvent[0];

        void scanDirectory(File directory) throws IOException {
            // Use the Java FileScanner API.
            FileScanner scanner = new FileScanner(directory);

            // Add listeners for file events.
            scanner.addListener((path, fileEvent) -> {
                FileEvent[] newFileEvents = new FileEvent[fileEvents.length + 1];
                System.arraycopy(fileEvents, 0, newFileEvents, 0, fileEvents);
                newFileEvents[newFileEvents.length - 1] = fileEvent;
                fileEvents = newFileEvents;
            });

            // Get the found files and file events.
            foundFiles = scanner.getFoundFiles();
            fileEvents = scanner.getFileEvents();

            // Close the scanner.
            scanner.close();
        }

        Path[] getFoundFiles() {
            return foundFiles;
        }

        FileEvent[] getFileEvents() {
            return fileEvents;
        }
    }

    static abstract class FileEvent {
        @Override
        public String toString() {
            return this.getClass().getName();
        }
    }

    static class FileCreatedEvent extends FileEvent {
        // No additional data for this event.
    }

    static class FileDeletedEvent extends FileEvent {
        // No additional data for this event.
    }

    static class FileRenamedEvent extends FileEvent {
        // No additional data for this event.
    }
}