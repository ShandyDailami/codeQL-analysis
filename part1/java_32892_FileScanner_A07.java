import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_32892_FileScanner_A07 {

    private static final Pattern ILLEGAL_FILENAMES = Pattern.compile("[^A-Za-z0-9._%+-]");

    public static void main(String[] args) {
        String directory = "./src";
        File file = new File(directory);

        File[] unsafeFiles = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !isSafe(pathname.getName());
            }
        });

        if (unsafeFiles != null) {
            for (File unsafeFile : unsafeFiles) {
                System.out.println("Found unsafe file: " + unsafeFile.getAbsolutePath());
            }
        } else {
            System.out.println("No unsafe files found.");
        }
    }

    private static boolean isSafe(String name) {
        return !ILLEGAL_FILENAMES.matcher(name).matches();
    }
}