import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class java_00060_FileScanner_A08 {

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        Path path = Paths.get(directory);

        try (Stream<Path> walk = Files.walk(path)) {
            List<Path> dirs = walk
                    .filter(Files::isDirectory)
                    .map(Path::normalize)
                    .collect(Collectors.toList());

            List<Path> files = walk
                    .filter(Files::isRegularFile)
                    .map(Path::normalize)
                    .collect(Collectors.toList());

            // Checking integrity of directories
            for (Path dir : dirs) {
                checkDirectoryIntegrity(dir);
            }

            // Checking integrity of files
            for (Path file : files) {
                checkFileIntegrity(file);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkDirectoryIntegrity(Path dir) {
        try {
            // Insert your directory integrity check code here
            // For example, check if the directory is empty
            if (Files.list(dir).iterator().hasNext()) {
                System.out.println("Directory " + dir + " is not empty, integrity check failed.");
            } else {
                System.out.println("Directory " + dir + " is empty, integrity check passed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkFileIntegrity(Path file) {
        try {
            // Insert your file integrity check code here
            // For example, check if the file is empty
            if (Files.size(file) == 0) {
                System.out.println("File " + file + " is empty, integrity check failed.");
            } else {
                System.out.println("File " + file + " is not empty, integrity check passed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}