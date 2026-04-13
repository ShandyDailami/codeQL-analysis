import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class java_21039_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Replace with your directory
        scanDirectory(directory);
    }

    private static void scanDirectory(String directory) {
        File root = new File(directory);
        File[] files = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // We only accept .txt files
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                try {
                    // Read file content
                    byte[] byteContent = Files.readAllBytes(file.toPath());
                    // Check if file contains sensitive information
                    if (checkSensitiveInformation(byteContent)) {
                        System.out.println("Detected sensitive information in: " + file.getAbsolutePath());
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file.getAbsolutePath());
                }
            });
        }
    }

    private static boolean checkSensitiveInformation(byte[] byteContent) {
        // Here you can implement the logic to check the content for sensitive information
        // This is a placeholder and should be replaced by your own logic
        return false;
    }
}