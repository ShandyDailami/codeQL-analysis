import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_41289_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileName = "file.txt";

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            try (Stream<File> files = Files.list(Paths.get(directoryPath)).filter(file -> file.getName().equals(fileName))) {
                files.forEach(file -> System.out.println("File found: " + file.getPath()));
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        } else {
            System.out.println("Directory does not exist or is not a directory: " + directoryPath);
        }
    }
}