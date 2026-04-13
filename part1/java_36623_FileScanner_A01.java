import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_36623_FileScanner_A01 {
    private static final String ROOT_DIR = "C:\\Windows";
    private static final String BROKEN_FILE_EXTENSION = ".SYS";

    public static void main(String[] args) {
        File rootDir = new File(ROOT_DIR);
        findBrokenFiles(rootDir);
    }

    private static void findBrokenFiles(File dir) {
        File[] brokenFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(BROKEN_FILE_EXTENSION);
            }
        });

        if (brokenFiles != null) {
            Arrays.stream(brokenFiles).forEach(file -> printBrokenFile(file));
        }

        File[] subDirs = dir.listFiles(File::isDirectory);
        if (subDirs != null) {
            Arrays.stream(subDirs).forEach(BrokenAccessControl::findBrokenFiles);
        }
    }

    private static void printBrokenFile(File file) {
        System.out.println("Broken file found: " + file.getAbsolutePath());
    }
}