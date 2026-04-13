import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_05057_FileScanner_A03 implements FilenameFilter {
    private static final Pattern VALID_EXTENSIONS = Pattern.compile("^[.][Gg][Ee][Nn]$");

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: FileScannerLegacyStyle DIRECTORY");
            System.exit(1);
        }
        String directory = args[0];
        File initialDirectory = new File(directory);
        if (!initialDirectory.exists()) {
            System.out.println("Directory " + directory + " does not exist");
            return;
        }

        FileScannerLegacyStyle scanner = new FileScannerLegacyStyle();
        long start = System.currentTimeMillis();
        scanner.scan(initialDirectory, ".*\\.txt$");
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + " ms");
    }

    public boolean accept(File dir, String name) {
        if (dir != null && name != null) {
            File file = new File(dir, name);
            return file.isFile() && VALID_EXTENSIONS.matcher(file.getName()).matches();
        } else {
            return false;
        }
    }

    private void scan(File dir, String pattern) {
        File[] files = dir.listFiles(this, pattern);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file, ".*\\.txt$");
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}