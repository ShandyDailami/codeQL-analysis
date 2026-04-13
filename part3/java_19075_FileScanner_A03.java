import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_19075_FileScanner_A03 {

    public static void main(String[] args) {
        String rootDir = "src"; // replace with your directory
        String extension = ".txt"; // replace with your extension
        scan(rootDir, extension);
    }

    private static void scan(String rootDir, String extension) {
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        };

        File root = new File(rootDir);
        File[] files = root.listFiles(filter);

        if (files != null) {
            Arrays.stream(files).forEach(FileScanner::printInfo);
        } else {
            System.out.println("No files with extension: " + extension + " found in directory: " + rootDir);
        }
    }

    private static void printInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}