import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_13953_FileScanner_A01 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(startingDirectory, "*")) {
            for (Path path : stream) {
                if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                    printDirectoryInfo(path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDirectoryInfo(Path path) {
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.printf("Path %s is a directory%n", path);
            System.out.printf("  Its absolute filename is %s%n", path.toString());
            System.out.printf("  Its total size is %d%n", attributes.size());
            System.out.printf("  Its last modification date is %s%n", attributes.lastModifiedTime().toString());
            System.out.printf("  Its last access date is %s%n", attributes.lastAccessTime().toString());
            System.out.printf("  Its creation date is %s%n", attributes.creationTime().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}