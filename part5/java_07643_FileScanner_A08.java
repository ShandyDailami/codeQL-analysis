import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_07643_FileScanner_A08 {
    private static final Pattern VALID_EXTENSIONS = Pattern.compile("^.+\\.(txt|doc|pdf|xlsx)$");

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        SecurityChecker securityChecker = new SecurityChecker() {
            @Override
            public boolean accept(File pathname) {
                // Accept only directories and files with a valid extension
                return pathname.isDirectory() || VALID_EXTENSIONS.matcher(pathname.getName()).matches();
            }
        };
        File[] filesAndDirs = rootDirectory.listFiles(securityChecker);
        if (filesAndDirs == null) return;

        for (File file : filesAndDirs) {
            System.out.println("File: " + file.getAbsolutePath());
        }
    }

    interface SecurityChecker extends FileFilter, FilenameFilter {
    }
}