import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_07609_FileScanner_A07 {
    private static Pattern classFileNamePattern = Pattern.compile(".*\\.java$");

    public static void main(String[] args) {
        scanDirectory(new File("."));
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) return;
        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file);
            } else if (file.getName().endsWith(".java")) {
                System.out.println("Found Java file: " + file.getAbsolutePath());
            }
        }
    }
}