import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_33536_FileScanner_A07 {

    private static final PathMatcher<Path> fileMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");

    public static void main(String[] args) {
        Path startingDirectory = Paths.get("src/main/java");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory)) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path) && fileMatcher.matches(path.getFileName())) {
                    fileReadOperation(path);
                }
            }
        } catch (IOException e) {
            System.out.println("Error accessing directory: " + startingDirectory);
        }
    }

    private static void fileReadOperation(Path path) {
        try (InputStream inputStream = Files.newInputStream(path)) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + path.getFileName());
        }
    }
}