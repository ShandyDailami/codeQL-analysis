import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class java_27783_FileScanner_A01 {

    private static final String DIRECTORY = "/path/to/directory";

    public static void main(String[] args) {
        File dir = new File(DIRECTORY);
        File[] listOfFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("Unable to list directory: " + dir);
        }
    }
}