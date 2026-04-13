import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_02697_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String extension = ".txt";

        try {
            Files.walk(Paths.get(directory))
                 .filter(Files::isRegularFile)
                 .filter(file -> file.toString().endsWith(extension))
                 .forEach(FileScanner::printFileInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFileInfo(Path path) {
        if (Files.isReadable(path)) {
            try {
                System.out.println(path.toAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}