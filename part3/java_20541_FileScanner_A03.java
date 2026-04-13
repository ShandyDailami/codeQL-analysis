import java.io.File;
import java.util.Arrays;
import java.util.List;

public class java_20541_FileScanner_A03 {

    private static final String DIRECTORY_PATH = "C:\\temp";
    private static final String EXCLUDED_EXTENSION = "exe";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        File[] files = directory.listFiles();

        if (files != null) {
            List<File> excludedFiles = Arrays.asList(files);

            for (File file : files) {
                if (file.isFile() && !excludedFiles.contains(file) && file.getName().endsWith(EXCLUDED_EXTENSION)) {
                    System.out.println("Processing file: " + file.getName());
                    // Insert your processing code here
                }
            }
        }
    }
}