import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class java_01578_FileScanner_A07 {
    private static final String PATH = "path_to_directory";

    public static void main(String[] args) {
        try (Stream<Path> paths = Files.walk(Paths.get(PATH))) {
            paths.forEach(AuthFailureScanner::checkFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkFile(Path path) {
        if (Files.isRegularFile(path)) {
            long size = Files.size(path);
            long creationTime = Files.getLastModifiedTime(path).toMillis();

            // Security-sensitive operations related to A07_AuthFailure
            if (size > MAX_SIZE || creationTime > MAX_CREATION_TIME) {
                System.out.println("File: " + path.toString() + " is potentially dangerous");
            }
        }
    }

    private static final long MAX_SIZE = 1024 * 1024; // 1MB
    private static final long MAX_CREATION_TIME = 1609459200000L; // 2020-01-01
}