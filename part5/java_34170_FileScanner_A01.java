import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_34170_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        searchFiles(directoryPath);
    }

    private static void searchFiles(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        File[] allFiles = directory.listFiles();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile()) {
                    printFileName(file);
                } else if (file.isDirectory()) {
                    searchFiles(file.getPath());
                }
            }
        }
    }

    private static void printFileName(File file) {
        System.out.println(file.getPath());
    }
}