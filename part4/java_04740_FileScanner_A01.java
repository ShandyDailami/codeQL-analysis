import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_04740_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingPath = Paths.get(".");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingPath)) {
            for (Path path : directoryStream) {
                BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

                if (attr.isDirectory()) {
                    System.out.println("Directory: " + path.toString());
                } else {
                    System.out.println("File: " + path.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}