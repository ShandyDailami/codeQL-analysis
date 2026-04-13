import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class java_32322_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory
        String regex = ".*\\.txt$"; // regex for text files

        File directory = new File(directoryPath);

        if (directory.exists()) {
            listTextFiles(directory, regex);
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void listTextFiles(File directory, String regex) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.matches(regex, name);
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Path path = Paths.get(file.getPath());
                    if (Files.exists(path)) {
                        System.out.println(file.getPath());
                    } else {
                        System.out.println("File exists, but directory access is restricted: " + file.getPath());
                    }
                }
            }
        } else {
            System.out.println("No files found in directory.");
        }
    }
}