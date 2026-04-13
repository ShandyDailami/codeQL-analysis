import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_36634_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        Files.walk(Paths.get("/path/to/files"), 2) // start from "/path/to/files" and go up two directories
            .filter(Files::isRegularFile)
            .filter(path -> matcher.matches(path.getFileName()))
            .forEach(file -> System.out.println(file.getFileName())); // print file name
    }
}