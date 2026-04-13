import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_37142_FileScanner_A08 {
    private static final Pattern VALID_EXTENSION = Pattern.compile("\\.txt$");

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Usage: java Main directory extension");
        }

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return VALID_EXTENSION.matcher(pathname.getName()).matches();
            }
        };

        File file = new File(args[0]);
        findFiles(file, filter);
    }

    private static void findFiles(File file, FileFilter filter) {
        if (file.isDirectory()) {
            for (File innerFile : file.listFiles(filter)) {
                findFiles(innerFile, filter);
            }
        } else if (file.getName().endsWith(".txt")) {
            System.out.println("File found: " + file.getAbsolutePath());
        }
    }
}