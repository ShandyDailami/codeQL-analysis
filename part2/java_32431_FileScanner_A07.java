import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_32431_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        BasicFileAttributes attributes;

        try {
            attributes = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        FileSystem fs = path.getFileSystem();
        FileStore store = attributes.asFileStore();

        try {
            Files.walk(path, FileVisitOption.FOLLOW_LINKS)
                .filter(p -> Files.isRegularFile(p))
                .forEach(p -> {
                    try {
                        FileTime accessTime = Files.getLastModifiedTime(p);
                        FileTime modificationTime = Files.getLastModifiedTime(p);
                        long size = Files.size(p);

                        System.out.println(
                            "File: " + p + "\n" +
                            "Access time: " + accessTime + "\n" +
                            "Modification time: " + modificationTime + "\n" +
                            "Size: " + size + "\n"
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

            try {
                Files.list(path)
                    .forEach(p -> {
                        if (Files.isDirectory(p, LinkOption.NOFOLLOW_LINKS)) {
                            try {
                                FileTime accessTime = Files.getLastModifiedTime(p, LinkOption.NOFOLLOW_LINKS);
                                FileTime modificationTime = Files.getLastModifiedTime(p, LinkOption.NOFOLLOW_LINKS);
                                long size = Files.size(p, LinkOption.NOFOLLOW_LINKS);

                                System.out.println(
                                    "Directory: " + p + "\n" +
                                    "Access time: " + accessTime + "\n" +
                                    "Modification time: " + modificationTime + "\n" +
                                    "Size: " + size + "\n"
                                );
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

            } catch (UnsupportedOperationException e) {
                System.out.println("Unsupported operation exception: " + e.getMessage());
            }

        } catch (FileSystemNotFoundException | NotDirectoryException | AccessDeniedException e) {
            e.printStackTrace();
        }
    }
}