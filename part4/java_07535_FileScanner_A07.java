import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_07535_FileScanner_A07 {
    public static void main(String[] args) {
        File dir = new File("."); // current directory
        String pattern = "*.java"; // the pattern to match
        findFiles(dir, pattern);
    }

    private static void findFiles(File dir, final String pattern) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(pattern);
            }
        });

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}