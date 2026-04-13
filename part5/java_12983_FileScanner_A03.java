import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_12983_FileScanner_A03 {
    public static void main(String[] args) {
        File dir = new File("."); // Current directory

        // Define the regex pattern
        Pattern pattern = Pattern.compile(".*textfile1.*");

        // Use FileFilter for recursive file scanning
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                // Check if the file name matches the pattern
                if (pattern.matcher(pathname.getName()).matches()) {
                    return true;
                }
                return false;
            }
        };

        // Scan the directory and its subdirectories
        findFiles(dir, fileFilter);
    }

    public static void findFiles(File dir, FileFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findFiles(file, filter);
                } else {
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            }
        }
    }
}