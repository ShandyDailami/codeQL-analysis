import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_23939_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String pattern = "pattern.txt"; // replace with your file pattern

        File dir = new File(directoryPath);
        File[] matchingFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.matches(pattern, name);
            }
        });

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println("Matching file: " + file.getPath());
            }
        } else {
            System.out.println("No files found that match the pattern.");
        }
    }
}