import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_38980_FileScanner_A07 {
    private static final Pattern FILE_NAME_PATTERN = Pattern.compile(".*\\.(?:txt|java)$", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String searchPattern = "search_pattern";

        File startingDirectory = new File(directory);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return FILE_NAME_PATTERN.matcher(pathname.getName()).matches()
                        && pathname.isFile()
                        && FILE_NAME_PATTERN.matcher(pathname.getName()).matches();
            }
        };

        search(startingDirectory, filter, searchPattern);
    }

    private static void search(File directory, FileFilter filter, String searchPattern) {
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    search(file, filter, searchPattern);
                } else {
                    if (file.getName().contains(searchPattern)) {
                        System.out.println("Found file: " + file.getPath());
                    }
                }
            }
        }
    }
}