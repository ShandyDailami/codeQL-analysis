import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_08226_FileScanner_A03 {
    public static void main(String[] args) {
        File rootDir = new File(".");
        FileScanner scanner = new FileScanner(rootDir, new TextFileFilter());
        File[] foundFiles = scanner.findAll();

        // Print found file names
        Arrays.stream(foundFiles).forEach(file -> System.out.println(file.getAbsolutePath()));
    }

    static class FileScanner {
        private File rootDir;
        private FileFilter filter;

        public java_08226_FileScanner_A03(File rootDir, FileFilter filter) {
            this.rootDir = rootDir;
            this.filter = filter;
        }

        public File[] findAll() {
            return rootDir.listFiles(filter);
        }
    }

    static class TextFileFilter implements FileFilter {
        public boolean accept(File pathname) {
            return pathname.getName().toLowerCase().endsWith(".txt");
        }
    }
}