import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileAttributeView;
import java.nio.file.StandardCopyOption;

public class java_22348_FileScanner_A03 {

    private static final long MAX_FILE_SIZE = 5242880L; // 5MB
    private static final String TARGET_DIRECTORY = "target";

    public static void main(String[] args) {
        File targetDirectory = new File(TARGET_DIRECTORY);

        if (!targetDirectory.exists()) {
            targetDirectory.mkdir();
        }

        File[] files = targetDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.length() > MAX_FILE_SIZE) {
                    try {
                        Files.copy(file.toPath(), Path.of(TARGET_DIRECTORY, file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}