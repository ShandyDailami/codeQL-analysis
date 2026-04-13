import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class java_17438_FileScanner_A08 {
    public static void main(String[] args) {
        final String dirPath = "/path/to/your/directory";  // Replace with your directory path
        final long lastModifiedThreshold = System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(10);

        File directory = new File(dirPath);
        File[] files = directory.listFiles();

        if (files != null) {
            List<File> modifiedFiles = Arrays.asList(files);
            modifiedFiles.stream()
                    .filter(file -> file.lastModified() > lastModifiedThreshold)
                    .forEach(file -> System.out.println("Modified: " + file.getAbsolutePath()));
        }
    }
}