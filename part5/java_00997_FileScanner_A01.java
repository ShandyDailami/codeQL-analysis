import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_00997_FileScanner_A01 {
    private static final Pattern PATH_PATTERN = Pattern.compile("\\p{InJavaWhitetable}+");

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner();
        fileScanner.scan(".", ".*");
    }
}

class FileScanner {
    private File[] foundFiles;

    public void scan(String directory, String filter) {
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return PATH_PATTERN.matcher(pathname.getPath()).matches();
            }
        };

        FilenameFilter filenameFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return fileFilter.accept(new File(dir, name));
            }
        };

        File root = new File(directory);
        foundFiles = root.listFiles(filenameFilter);

        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isDirectory()) {
                    scan(file.getPath(), filter);
                } else {
                    System.out.println(file.getPath());
                }
            }
        }
    }
}