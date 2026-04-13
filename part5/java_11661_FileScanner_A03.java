import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_11661_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Specify the directory path here
        String regex = "pattern"; // Specify the regex here

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.matches(regex, name);
            }
        };

        searchFiles(directory, filter);
    }

    public static void searchFiles(File directory, FilenameFilter filter) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles(filter)) {
                if (file.isDirectory()) {
                    searchFiles(file, filter);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}