import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_09288_FileScanner_A08 {

    private static final Pattern FILE_NAME_PATTERN = Pattern.compile("A08_IntegrityFailure");

    public static void main(String[] args) {
        FileScanner(".", ".*");
    }

    private static void FileScanner(String directory, String pattern) {
        File root = new File(directory);
        File[] files = root.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return FILE_NAME_PATTERN.matcher(name).matches();
            }
        });
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Perform security sensitive operations here
                    // For now, just print the file name
                    System.out.println(file.getPath());
                } else if (file.isDirectory()) {
                    FileScanner(file.getPath(), pattern);
                }
            }
        }
    }
}