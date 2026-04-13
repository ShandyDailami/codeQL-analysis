import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_10353_FileScanner_A07 {
    // Set of file paths to avoid duplicate entries
    private Set<String> seen = new HashSet<>();

    // File path filter
    private String filter;

    public java_10353_FileScanner_A07(String filter) {
        this.filter = filter;
    }

    public void scan(String directory) {
        File file = new File(directory);
        scan(file);
    }

    public void scan(File file) {
        File[] list = file.listFiles();
        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                scan(f);
            } else if (f.getName().endsWith(filter)) {
                if (!seen.contains(f.getAbsolutePath())) {
                    seen.add(f.getAbsolutePath());
                    // Do something with file
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        new UniqueFileScanner(".txt").scan(".");
    }
}