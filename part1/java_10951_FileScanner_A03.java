import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_10951_FileScanner_A03 {

    public static void main(String[] args) {
        Path path = Paths.get(".");
        BasicFileAttributes attributes;

        try {
            attributes = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {
            System.out.println("Error reading file attributes");
            return;
        }

        if (attributes.isDirectory()) {
            System.out.println("Path is a directory");
        } else if (attributes.isRegularFile()) {
            System.out.println("Path is a regular file");

            FileSystem fs = FileSystems.newFileSystem(path, null);
            FileTime lastModified = fs.getFileAttributeView(PathAttributeView.FaileAttributeView.class, StandardFileAttributeViews.FileAttributeViewAccess.readOnly()).lastModifiedTime();
            System.out.println("Last modified: " + lastModified);

            FileVisitResult result;
            try {
                result = Files.walkFileTree(path, FileVisitOption.FOLLOW_LINKS);
            } catch (IOException e) {
                System.out.println("Error walking file tree");
                return;
            }

            if (result == FileVisitResult.TERMINATED) {
                System.out.println("File found");
            }
        } else {
            System.out.println("Path is not recognized");
        }
    }
}