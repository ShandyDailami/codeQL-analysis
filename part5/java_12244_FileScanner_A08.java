import java.io.File;
import java.util.Arrays;

public class java_12244_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String extension = ".txt"; // replace with your file extension

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getAbsolutePath()));
        } else {
            System.out.println("No files found with the extension " + extension);
        }
    }
}