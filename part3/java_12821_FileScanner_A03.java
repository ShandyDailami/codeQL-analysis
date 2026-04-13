import java.io.File;
import java.util.regex.Pattern;

public class java_12821_FileScanner_A03 {

    private static final Pattern TEXT_FILES_PATTERN = Pattern.compile(".*\\.(txt)$");

    public static void main(String[] args) {
        String directoryPath = "."; // Change this to your directory
        File directory = new File(directoryPath);

        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isFile() && TEXT_FILES_PATTERN.matcher(file.getName()).matches()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                scanDirectory(file);
            }
        }
    }
}