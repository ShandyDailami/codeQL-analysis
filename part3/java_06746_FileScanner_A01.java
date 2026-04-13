import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;

public class java_06746_FileScanner_A01 {

    public static void main(String[] args) throws Exception {
        FileSystems.getDefault().register(
                Path.of("."),
                new SimpleFileVisitor(),
                WatchEvent.Kinds.ENTRY_CREATE,
                WatchEvent.Kinds.ENTRY_MODIFY,
                WatchEvent.Kinds.ENTRY_DELETE
        );

        WatchService watchService = FileSystems.getDefault().newWatchService();

        watchService.watch(Path.of("."), StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        Path path = Path.of(".");
        boolean valid = true;

        while (valid) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    Path newFile = (Path) event.context();
                    System.out.println(newFile.toAbsolutePath().toString() + " created");
                } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    Path modifiedFile = (Path) event.context();
                    System.out.println(modifiedFile.toAbsolutePath().toString() + " modified");
                } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    Path deletedFile = (Path) event.context();
                    System.out.println(deletedFile.toAbsolutePath().toString() + " deleted");
                }

                key.reset();
            }
        }

        watchService.close();
    }

    private static class SimpleFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!file.getFileSystem().equals(FileSystems.getDefault())) {
                return FileVisitResult.CONTINUE;
            }

            if (file.equals(Path.of("."))) {
                return FileVisitResult.TERMINATE;
            }

            System.out.println("Skipping file: " + file.toAbsolutePath());
            return FileVisitResult.CONTINUE;
        }
    }
}