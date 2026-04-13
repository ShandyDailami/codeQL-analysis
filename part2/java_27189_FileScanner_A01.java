import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class java_27189_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        File directory = new File("src/main/resources");

        Map<String, Integer> directoryCounts = new HashMap<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory.toPath(), path -> Files.isRegularFile(path))) {
            for (Path path : directoryStream) {
                String name = path.getFileName().toString();
                int separatorIndex = name.lastIndexOf('.');
                if (separatorIndex != -1) {
                    String extension = name.substring(separatorIndex + 1);
                    directoryCounts.put(extension, directoryCounts.getOrDefault(extension, 0) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : directoryCounts.entrySet()) {
            System.out.println("Directory with extension " + entry.getKey() + " has " + entry.getValue() + " files");
        }
    }
}