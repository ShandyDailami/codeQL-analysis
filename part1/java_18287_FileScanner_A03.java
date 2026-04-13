import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.security.InvalidParameterException;

public class java_18287_FileScanner_A03 {
    private final WatchService watchService;
    private final Path initialDirectory;

    public java_18287_FileScanner_A03(String initialDirectoryPath) {
        if (initialDirectoryPath == null || initialDirectoryPath.isEmpty()) {
            throw new InvalidParameterException("Initial directory path cannot be null or empty");
        }

        this.initialDirectory = FileSystems.getDefault().getPath(initialDirectoryPath);
        try {
            watchService = FileSystems.getDefault().newWatchService();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create a new WatchService", e);
        }
    }

    public void startScanning() {
        try {
            watchService.watch(initialDirectory, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

            // Keep the program running until it's manually stopped
            while (true) {
                WatchEvent<?> event = watchService.take();
                WatchEvent<Path> watchEvent = (WatchEvent<Path>) event;

                if (watchEvent.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    Path createdFile = watchEvent.context();
                    System.out.println("File created: " + createdFile);
                } else if (watchEvent.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    Path modifiedFile = watchEvent.context();
                    System.out.println("File modified: " + modifiedFile);
                } else if (watchEvent.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                    Path deletedFile = watchEvent.context();
                    System.out.println("File deleted: " + deletedFile);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        } finally {
            watchService.close();
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("/path/to/directory");
        scanner.startScanning();
    }
}