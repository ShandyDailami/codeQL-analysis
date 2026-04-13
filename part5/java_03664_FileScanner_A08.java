import java.nio.file.*;
import java.io.*;

public class java_03664_FileScanner_A08 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(".");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toFile().isFile()) {
                    FileInfo fileInfo = new FileInfo(file);
                    if (isFileTampered(fileInfo)) {
                        System.out.println("File " + file.toString() + " has been tampered with");
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static boolean isFileTampered(FileInfo fileInfo) {
        // This is a placeholder for a more complex method to check for tampering
        // This will just check if the file is empty or not
        File file = fileInfo.getFile();
        if (file.length() == 0) {
            return true;
        }
        return false;
    }

    static class FileInfo {
        private final File file;

        public java_03664_FileScanner_A08(File file) {
            this.file = file;
        }

        public File getFile() {
            return file;
        }
    }
}