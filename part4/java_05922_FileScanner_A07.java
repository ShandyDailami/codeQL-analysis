import java.nio.file.*;

public class java_05922_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get(".");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry)) {
                    FileSystem fs = FileSystems.newFileSystem(entry, null);

                    try (DirectoryStream<Path> nestedStream = Files.newDirectoryStream(entry, "*.txt", RecursiveOption.FOLLOW_LINKS)) {
                        for (Path nestedEntry : nestedStream) {
                            if (Files.isRegularFile(nestedEntry)) {
                                System.out.println("Found text file: " + nestedEntry);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}