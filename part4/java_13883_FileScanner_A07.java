import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_13883_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath().normalize();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, "**/*.java")) {
            for (Path path : directoryStream) {
                FileVisitResult result;
                try {
                    result = Files.walkFileTree(path, FileVisitOption.FOLLOW_LINKS);
                } catch (IOException e) {
                    result = FileVisitResult.CONTINUE;
                }

                if (result == FileVisitResult.CONTINUE) {
                    if (Files.isRegularFile(path) && !path.toString().contains("AuthFailure")) {
                        System.out.println(path.toString());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}