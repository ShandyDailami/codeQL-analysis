import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class java_28698_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        FileScanner(directoryPath);
    }

    public static void FileScanner(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                Path path = Paths.get(file.getAbsolutePath());
                long length = Files.size(path);
                System.out.println("File: " + file.getAbsolutePath() + ", Size: " + length + " bytes");
            } else {
                FileScanner(file.getAbsolutePath());
            }
        }
    }
}