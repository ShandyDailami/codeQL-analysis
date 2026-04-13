import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class java_34596_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        String fileExtension = ".*\\.txt";  // replace with your file extension

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("Directory does not have read permissions.");
            return;
        }

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return Pattern.matches(fileExtension, name);
            }
        };

        try {
            Files.walk(Paths.get(directoryPath))
                .filter(path -> Files.isRegularFile(path))
                .forEach(path -> {
                    File file = path.toFile();
                    if (file.getName().matches(fileExtension)) {
                        System.out.println(file.getName());
                    }
                });
        } catch (IOException e) {
            System.out.println("An error occurred while scanning the directory: " + e.getMessage());
        }
    }
}