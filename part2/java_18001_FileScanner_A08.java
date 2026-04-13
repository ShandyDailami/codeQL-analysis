import java.nio.file.*;

public class java_18001_FileScanner_A08 {
    public static void main(String[] args) {
        Path dir = Paths.get("."); // Change this to the directory you want to scan
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(dir)) {
            for (Path path : dirs) {
                if (Files.isRegularFile(path)) {
                    FileAttributes attr = Files.readAttributes(path, FileAttributes.class);
                    long size = attr.size();
                    if (size > 0) {
                        System.out.println("Regular file: " + path.toString());
                    }
                } else if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}