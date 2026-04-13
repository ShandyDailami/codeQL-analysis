import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_06402_FileScanner_A03 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*.java")) {
            for (Path path : dirs) {
                FileTime lastModifiedTime = Files.getLastModifiedTime(path);
                FileTime lastAccessTime = Files.getLastAccessTime(path);
                FileTime createTime = Files.getCreatedTime(path);
                System.out.println("File: " + path);
                System.out.println("Last Modified Time: " + lastModifiedTime);
                System.out.println("Last Access Time: " + lastAccessTime);
                System.out.println("Creation Time: " + createTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}