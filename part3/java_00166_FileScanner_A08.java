import java.io.IOException;
import java.nio.file.*;

public class java_00166_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path_to_directory";
        try (Stream<Path> paths = Files.newDirectoryStream(Paths.get(directoryPath))) {
            for (Path path : paths) {
                if (Files.isRegularFile(path)) {
                    try (InputStream inStream = Files.newInputStream(path)) {
                        int data;
                        while ((data = inStream.read()) != -1) {
                            System.out.print((char) data);
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + path.toString());
                    }
                } else if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path.toString());
                }
            }
        } catch (IOException e) {
            System.out.println("Error accessing directory: " + directoryPath);
        }
    }
}