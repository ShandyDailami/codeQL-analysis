import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

public class java_23279_FileScanner_A03 {
    private static final String DIRECTORY_TO_SCAN = "/path/to/directory";
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        Set<String> fileNames = new HashSet<>();

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**." + FILE_EXTENSION);
        Files.walkFileTree(Paths.get(DIRECTORY_TO_SCAN), matcher)
            .forEach(path -> fileNames.add(path.toString()));

        fileNames.forEach(System.out::println);
    }
}