import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_40017_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";

        // Using File class and its methods
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
            for (File file : files) {
                System.out.println(file.getName());
            }
        }

        // Using FileFilter
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };
        directory.list(filter);

        // Using FilenameFilter
        FilenameFilter filter2 = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.matches(".*\\.txt$", name);
            }
        };
        directory.listFiles(filter2);
    }
}