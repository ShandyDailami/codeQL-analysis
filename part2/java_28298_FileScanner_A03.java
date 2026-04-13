import java.io.File;
import java.io.FileFilter;

public class java_28298_FileScanner_A03 {

    // FileScanner class implementation
    public static class FileScanner implements FileFilter {

        private String extension;

        public java_28298_FileScanner_A03(String extension) {
            this.extension = extension;
        }

        public boolean accept(File pathname) {
            // Check if the file is a directory
            if (pathname.isDirectory()) {
                return false;
            }

            // Check if the file name ends with the given extension
            if (pathname.getName().toLowerCase().endsWith(this.extension.toLowerCase())) {
                return true;
            }

            return false;
        }
    }

    // Main method to test the FileScanner
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("txt");

        File dir = new File(".");

        // Print all text files in the directory
        File[] files = dir.listFiles(scanner);
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}