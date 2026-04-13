import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class java_23545_FileScanner_A07 {

    public static void main(String[] args) {
        // Create a new File object for the directory
        File directory = new File(".");

        // Create a list to store the file names
        List<String> fileNames = new ArrayList<>();

        // Use the Files.newDirectoryStream method to list all .txt files in the directory
        try (Files.newDirectoryStream(Paths.get(directory.getPath()), "*.txt")
                .forEach(path -> fileNames.add(path.toString()))) {
            // print all file names
            for (String name : fileNames) {
                System.out.println(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}