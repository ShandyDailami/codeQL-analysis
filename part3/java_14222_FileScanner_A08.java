import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class java_14222_FileScanner_A08 {
    private static final String DIR_PATH = "/path/to/directory";
    private static final String FILE_EXTENSION = "txt";
    private static final long MAX_FILE_SIZE = 1024 * 1024; // 1MB

    public static void main(String[] args) throws IOException {
        List<Path> filesToDelete = Files.list(Paths.get(DIR_PATH))
                .filter(path -> path.toString().endsWith("." + FILE_EXTENSION))
                .filter(path -> Files.size(path) > MAX_FILE_SIZE)
                .collect(Collectors.toList());

        for (Path file : filesToDelete) {
            try {
                Files.delete(file);
                System.out.println("Deleted file: " + file.toString());
            } catch (IOException e) {
                System.out.println("Failed to delete file: " + file.toString());
            }
        }
    }
}