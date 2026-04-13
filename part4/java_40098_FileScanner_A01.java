import java.nio.file.*;

public class java_40098_FileScanner_A01 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, "*.{txt,log}")) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    System.out.println(path.getFileName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}