import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_17684_FileScanner_A03 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("./");
        FileSystem fs = path.getFileSystem();

        try (DirectoryStream<Path> dirs = fs.newDirectoryStream(path, "*.txt")) {
            for (Path file : dirs) {
                BasicFileAttributes attrs = fs.readAttributes(file, BasicFileAttributes.class);
                if (attrs.isReadable() && attrs.isWritable()) {
                    System.out.println("File: " + file.toString());
                }
            }
        }
    }
}