import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class java_38578_FileScanner_A08 {
    private File[] roots;
    private FileFilter filter;

    public java_38578_FileScanner_A08(File[] roots, FileFilter filter) {
        this.roots = roots;
        this.filter = filter;
    }

    public void scan(String pattern) {
        // Create a pattern from the given string
        Pattern p = Pattern.compile(pattern);

        // Loop through each root directory
        for (File root : roots) {
            File[] files = root.listFiles(filter);

            if (files == null) continue;

            // Loop through each file in the root directory
            for (File file : files) {
                // If the file is a directory, recursively scan it
                if (file.isDirectory()) {
                    new FileScanner(new File[]{file}, null).scan(pattern);
                } else {
                    // If the file matches the pattern, print its name
                    if (p.matcher(file.getName()).matches()) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner(new File[]{new File(".") }, null);
        scanner.scan(".*");
    }
}