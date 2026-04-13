import java.nio.file.*;
import java.nio.file.attribute.*;

import java.io.*;

public class java_40823_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path startingPath = Paths.get(".");
        FileSystem fs = startingPath.getFileSystem();

        if (args.length == 1) {
            startingPath = Paths.get(args[0]);
        }

        try (DirectoryStream<Path> stream = fs.newDirectoryStream(startingPath)) {
            for (Path p : stream) {
                if (Files.isRegularFile(p)) {
                    FileAttributes attr = fs.readAttributes(p, BasicFileAttributes.class);
                    System.out.println(p.toString() + " (" + attr.size() + " bytes)");
                }
            }
        }
    }
}