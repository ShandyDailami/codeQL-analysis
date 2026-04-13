import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;

public class java_23795_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String pattern = ".*txt"; // modify this to match the file type you want to scan

        File startingDirectory = new File(directory);

        File[] matchingFiles = startingDirectory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return Pattern.matches(pattern, name);
            }
        });

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                if (file.isFile()) {
                    try {
                        System.out.println("File: " + file.getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getCanonicalPath());
                }
            }
        }
    }
}