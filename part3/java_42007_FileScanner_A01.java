import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_42007_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
        Files.walkFileTree(Paths.get("src/main/java"), new SimpleFileVisitor<>(), 1,
                RecursiveOption.FOLLOW_LINKS);

        System.out.println("Matching files: ");
        for (Path p : matcher.match(Paths.get("src/main/java"), false)) {
            FileTime lastModified = Files.getLastModifiedTime(p);
            FileTime creationTime = Files.getCreatedTime(p);
            FileTime lastAccessedTime = Files.getLastAccessTime(p);

            System.out.printf("  %s  lastModified %s  creationTime %s  lastAccessedTime %s%n",
                    p, lastModified, creationTime, lastAccessedTime);
        }
    }
}