import java.io.IOException;
import java.nio.file.*;

public class java_22223_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("."); // Start from current directory

        // Check for file system support
        if (Filesystems.exists(start)) {
            Filesystems.newFileSystem(start, null).find(".txt",
                    /* callback */ new java.nio.file.SearchCondition<Path>() {
                        @Override
                        public boolean accept(Path entry) throws IOException {
                            return entry.toString().endsWith(".txt");
                        }
                    }).forEach(System.out::println);
        } else {
            System.out.println("File system not found on " + start);
        }
    }
}