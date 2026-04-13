import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_38674_FileScanner_A07 {
    private static final Pattern FILE_FILTER = Pattern.compile(".*\\.txt$");

    public static void main(String[] args) {
        File rootDir = new File(".");
        findFiles(rootDir);
    }

    private static void findFiles(File dir) {
        File[] foundFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return (pathname.isFile() && FILE_FILTER.matcher(pathname).matches());
            }
        });

        if (foundFiles != null) {
            for (File file : foundFiles) {
                System.out.println(file.getAbsolutePath());
            }
        }

        File[] subDirs = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (subDirs != null) {
            for (File subDir : subDirs) {
                findFiles(subDir);
            }
        }
    }
}