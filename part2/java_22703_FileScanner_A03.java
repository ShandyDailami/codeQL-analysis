import java.io.File;
import java.io.FilenameFilter;
import java.security.SecureRandom;

public class java_22703_FileScanner_A03 {
    private static SecureRandom sr = new SecureRandom();

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace this with your directory path
        File directory = new File(directoryPath);

        listDirectory(directory);
    }

    private static void listDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listDirectory(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}