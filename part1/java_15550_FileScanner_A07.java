import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_15550_FileScanner_A07 {
    private static final String DIRECTORY = "C:\\YourDirectoryPath";

    public static void main(String[] args) throws IOException, InvalidPathException {
        Path directory = Paths.get(DIRECTORY);
        try (Stream<Path> paths = Files.walk(directory)) {
            List<Path> dirList = paths.filter(p -> Files.isDirectory(p)).collect(Collectors.toList());
            System.out.println("Directories: " + dirList);

            paths.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<Path> paths = Files.walk(directory)) {
            List<Path> fileList = paths.filter(p -> Files.isRegularFile(p)).collect(Collectors.toList());
            System.out.println("Files: " + fileList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}