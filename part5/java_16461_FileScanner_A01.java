import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_16461_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(start)) {
            for (Path p : ds) {
                if (Files.isDirectory(p, LinkOption.NOFOLLOW_LINKS)) {
                    System.out.println("Directory: " + p);
                    scanDirectory(p, 1);
                } else {
                    System.out.println("File: " + p);
                }
            }
        }
    }

    private static void scanDirectory(Path dir, int depth) throws IOException {
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir)) {
            for (Path p : ds) {
                if (Files.isDirectory(p, LinkOption.NOFOLLOW_LINKS)) {
                    System.out.println(depthToString(depth) + "Directory: " + p);
                    scanDirectory(p, depth + 1);
                } else {
                    System.out.println(depthToString(depth) + "File: " + p);
                }
            }
        }
    }

    private static String depthToString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}