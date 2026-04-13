import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_17904_FileScanner_A01 {
    private static Pattern pattern = Pattern.compile(".*\\.java$");

    public static void main(String[] args) {
        File dir = new File(".");
        scan(dir);
    }

    private static void scan(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file);
                } else if (file.isFile() && pattern.matcher(file.getName()).matches()) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}