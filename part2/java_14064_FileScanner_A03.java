import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_14064_FileScanner_A03 {

    public static void main(String[] args) {
        File rootDir = new File(".");
        FileScanner fileScanner = new FileScanner(rootDir, Pattern.compile(".*"));

        fileScanner.scan(new MyFileFilter());
    }

    public static class MyFileFilter implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            // Ignore directories
            if (pathname.isDirectory()) {
                return false;
            }

            // Accept all files, not just .java
            return true;
        }
    }

    public static class FileScanner {
        private File rootDir;
        private FileFilter fileFilter;

        public java_14064_FileScanner_A03(File rootDir, FileFilter fileFilter) {
            this.rootDir = rootDir;
            this.fileFilter = fileFilter;
        }

        public void scan(FileFilter fileFilter) {
            File[] foundFiles = rootDir.listFiles(fileFilter);
            if (foundFiles != null) {
                for (File file : foundFiles) {
                    if (file.isDirectory()) {
                        // Recursive scan of directory
                        scan(file);
                    } else {
                        // Do something with file
                        System.out.println("Found file: " + file.getPath());
                    }
                }
            }
        }
    }
}