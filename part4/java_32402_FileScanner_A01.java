import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_32402_FileScanner_A01 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.txt");
        FileVisitResult result;

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path path : directoryStream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                long size = attributes.size();
                FileTime creationTime = attributes.creationTime();
                FileTime lastModifiedTime = attributes.lastModifiedTime();

                System.out.printf("File %s size %d bytes, created %s, last modified %s%n", 
                    path, size, creationTime, lastModifiedTime);
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}