import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_23812_FileScanner_A07 {
    private static final String EXTENSION = ".*\\.txt$"; // Assuming text files end with .txt
    private static final Pattern VALID_EXTENSION = Pattern.compile(EXTENSION);

    public static void main(String[] args) {
        File currentDirectory = new File(".");
        String[] files = currentDirectory.list(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return VALID_EXTENSION.matcher(pathname.getName()).matches();
            }
        });

        if (files != null) {
            Arrays.sort(files);
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("No text files found in current directory.");
        }
    }
}