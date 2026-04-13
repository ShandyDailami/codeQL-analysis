import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_20014_FileScanner_A01 {
    private static final Pattern VALID_EXTENSIONS = Pattern.compile("^.+\\.txt$");

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: MinimalFileScanner <directory>");
            return;
        }
        String directory = args[0];
        File startingDirectory = new File(directory);
        if (!startingDirectory.isDirectory()) {
            System.out.println("Not a directory");
            return;
        }
        printFiles(startingDirectory, "");
    }

    private static void printFiles(File dir, String indent) {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && VALID_EXTENSIONS.matcher(pathname.getName()).matches();
            }
        });

        for (File file : files) {
            System.out.println(indent + file.getName());
        }

        File[] subdirs = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        for (File subdir : subdirs) {
            printFiles(subdir, indent + "  ");
        }
    }
}