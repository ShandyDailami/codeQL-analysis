import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_17762_FileScanner_A01 {

    private static final String DIRECTORY_PATH = "/path/to/directory";
    private static final String EXTENSIONS = ".*\\.txt$";

    public static void main(String[] args) throws Exception {
        Path directory = Paths.get(DIRECTORY_PATH);
        String pattern = "glob:*" + EXTENSIONS;

        Files.walkFileTree(directory, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isReadable(file)) {
                    String name = file.getFileName().toString();
                    if (name.matches(pattern)) {
                        System.out.println("Reading file: " + file);
                        // TODO: add code to process the file here
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}