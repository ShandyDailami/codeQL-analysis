import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_01786_FileScanner_A08 {

    private static final Set<String> EXCLUDE_EXTENSIONS = new HashSet<>(Arrays.asList("exe", "dll", "pdf"));

    public static void main(String[] args) {
        String directory = "C:\\test";  // replace with your directory
        scanDirectory(directory);
    }

    private static void scanDirectory(String directory) {
        File dir = new File(directory);
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && !EXCLUDE_EXTENSIONS.contains(getExtension(pathname.getName()));
            }
        });
        if (files != null) {
            for (File file : files) {
                System.out.println("File: " + file.getAbsolutePath());
            }
        }
    }

    private static String getExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if (lastDot == -1) {
            return "";
        } else {
            return filename.substring(lastDot + 1);
        }
    }
}