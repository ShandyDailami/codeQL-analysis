import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

public class java_10695_FileScanner_A01 {
    public static void main(String[] args) {
        Path directory = Paths.get("path_to_directory");
        try (FileSystem fs = directory.getFileSystem()) {
            Files.walkFileTree(directory, new SimpleFileVisitor<>())
                    .forEach(path -> {
                        try (BufferedReader reader = new BufferedReader(new FileReader(fs.getPath(path.toString()))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}