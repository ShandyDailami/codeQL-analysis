import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class java_06448_FileScanner_A07 {
    private static final Pattern VALID_FILE_EXTENSIONS = Pattern.compile("^.+\\.(\\w+)$");

    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/YourDirectory/"); // Specify your directory here
        scanDirectory(file);
    }

    private static void scanDirectory(File directory) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (isValidFile(file)) {
                    System.out.println("Valid file: " + file.getAbsolutePath());
                }
            }
        }
    }

    private static boolean isValidFile(File file) {
        String name = file.getName();
        return file.isFile() &&
                (VALID_FILE_EXTENSIONS.matcher(name).matches());
    }
}