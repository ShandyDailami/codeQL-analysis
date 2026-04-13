import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_18898_FileScanner_A03 {

    public static void main(String[] args) {
        String dir = "/path/to/directory";  // Replace with your directory
        String regex = ".*bad_pattern.*";  // Replace with your regex pattern

        File startingDirectory = new File(dir);

        File[] hiddenFiles = startingDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.isDirectory()) {
                    listHiddenFiles(hiddenFile, regex);
                } else {
                    System.out.println("File: " + hiddenFile.getAbsolutePath() + " is not a directory or does not match the regex pattern.");
                }
            }
        }
    }

    private static void listHiddenFiles(File directory, String regex) {
        File[] hiddenFiles = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.matches(regex, name);
            }
        });

        if (hiddenFiles != null) {
            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.isFile()) {
                    System.out.println("File: " + hiddenFile.getAbsolutePath());
                } else if (hiddenFile.isDirectory()) {
                    listHiddenFiles(hiddenFile, regex);
                }
            }
        }
    }
}