import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

class java_40343_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("."); // current directory
        try (Stream<Path> stream = Files.walk(path)) {
            stream.filter(Files::isReadable)
                .filter(p -> !Files.isDirectory(p))
                .forEach(Main::printFileInfo);
        }
    }

    private static void printFileInfo(Path p) throws Exception {
        // Remove comment
        // --------------------

        FileInfo fileInfo = new FileInfo(p.toString());

        // Get file name
        String fileName = fileInfo.getName();
        System.out.println("File Name : " + fileName);

        // Get file size
        long size = Files.size(p);
        System.out.println("File Size : " + size);

        // Get file creation time
        Instant creationTime = Files.getLastModifiedTime(p).toMillis();
        System.out.println("Creation Time : " + creationTime);

        // Get file last modified time
        Instant lastModified = Files.getLastModifiedTime(p).toMillis();
        System.out.println("Last Modified : " + lastModified);

        // --------------------

        // Remove comment
        // --------------------
    }

    static class FileInfo {
        private String name;

        public FileInfo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}