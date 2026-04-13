import java.io.IOException;
import java.nio.file.*;

public class java_05823_FileScanner_A07 {
    private static final String SEARCH_STRING = "AuthFailure";

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path path : directoryStream) {
                checkFileForAuthFailure(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkFileForAuthFailure(Path filePath) {
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(SEARCH_STRING)) {
                    System.out.println("Found auth failure in file: " + filePath.toString());
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}