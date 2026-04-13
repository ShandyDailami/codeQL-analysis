import java.io.*;
import java.nio.file.*;

public class java_28772_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\test\\"); // Change to your directory
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            for (Path file : files) {
                FileInfo info = new FileInfo(file);
                if (info.isHidden() || info.isSystem()) {
                    continue;
                }
                if (info.isDirectory()) {
                    printDirectoryContents(file);
                } else {
                    printFileContents(file);
                }
            }
        }
    }

    private static void printDirectoryContents(Path dir) throws IOException {
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir)) {
            for (Path entry : entries) {
                FileInfo info = new FileInfo(entry);
                if (info.isHidden() || info.isSystem()) {
                    continue;
                }
                if (info.isDirectory()) {
                    printDirectoryContents(entry);
                } else {
                    printFileContents(entry);
                }
            }
        }
    }

    private static void printFileContents(Path file) throws IOException {
        try (InputStream in = Files.newInputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
        }
    }

    private static class FileInfo {
        private final Path path;

        public java_28772_FileScanner_A08(Path path) {
            this.path = path;
        }

        public boolean isHidden() {
            return Files.isHidden(path);
        }

        public boolean isSystem() {
            return Files.isSystem(path);
        }

        public boolean isDirectory() {
            return Files.isDirectory(path);
        }
    }
}