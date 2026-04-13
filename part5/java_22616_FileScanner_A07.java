import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_22616_FileScanner_A07 {

    public static void main(String[] args) {
        String dirPath = "/path/to/directory";  // replace with your directory path
        String fileExtension = ".*\\.java$";  // Java files with .java extension
        scanDirectory(dirPath, fileExtension);
    }

    private static void scanDirectory(String dirPath, String fileExtension) {
        File directory = new File(dirPath);
        File[] matchingFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().matches(fileExtension);
            }
        });

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println("File found: " + file.getPath());
                // You can add your own security sensitive operations here, e.g., check file permissions
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}