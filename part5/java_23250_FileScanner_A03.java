import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_23250_FileScanner_A03 {
    public static void main(String[] args) {
        File root = new File(".");
        scan(root, null);
    }

    private static void scan(File dir, String regexp) {
        File[] files = dir.listFiles(regexp == null ? null : (dir1, name) -> name.matches(regexp));
        if (files == null) return;

        Arrays.stream(files).forEach(file -> {
            if (file.isDirectory()) {
                System.out.println("Scanning directory: " + file.getAbsolutePath());
                scan(file, regexp);
            } else {
                System.out.println("File: " + file.getAbsolutePath());
            }
        });
    }
}