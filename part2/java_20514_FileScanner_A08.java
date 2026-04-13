import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class java_20514_FileScanner_A08 {

    public static void main(String[] args) {
        // Check if the directory exists
        Path dir = Paths.get("path/to/directory");
        if (FileSystems.getDefault().exists(dir)) {
            try {
                // Create a new file and print its size
                Path file = FileSystems.getDefault().newFile(dir, "newfile");
                Files.writeString(file, "File created with FileScanner", StandardOpenOption.CREATE);
                long size = Files.size(file);
                System.out.println("Size of file: " + size);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}