import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_05693_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";
        File dir = new File(directory);
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isFile()) {
                    return true;
                }
                return false;
            }
        });
        if (files != null) {
            Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found!");
        }
    }
}