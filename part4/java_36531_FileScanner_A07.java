import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_36531_FileScanner_A07 {

    private static final String DIRECTORY_TO_SCAN = "target";
    private static final Set<String> SAFE_FILE_EXTENSIONS = new HashSet<>();

    static {
        SAFE_FILE_EXTENSIONS.add(".java");
        SAFE_FILE_EXTENSIONS.add(".xml");
        SAFE_FILE_EXTENSIONS.add(".txt");
        SAFE_FILE_EXTENSIONS.add(".json");
        SAFE_FILE_EXTENSIONS.add(".properties");
    }

    public static void main(String[] args) {
        File directoryToScan = new File(DIRECTORY_TO_SCAN);
        File[] filesToScan = directoryToScan.listFiles();

        if (filesToScan != null) {
            for (File file : filesToScan) {
                if (file.isFile() && isFileSafe(file)) {
                    System.out.println("Found safe file: " + file.getAbsolutePath());
                }
            }
        }
    }

    private static boolean isFileSafe(File file) {
        if (file.getName().endsWith(File.separator)) {
            return false;
        }

        String name = file.getName();
        int lastDot = name.lastIndexOf('.');

        if (lastDot == -1) {
            return false;
        }

        String extension = name.substring(lastDot + 1);

        return SAFE_FILE_EXTENSIONS.contains(extension);
    }
}