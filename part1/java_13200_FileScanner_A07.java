import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_13200_FileScanner_A07 {

    public static void main(String[] args) {
        File rootDir = new File("."); // current directory
        FileScanner scanner = new FileScanner(rootDir);
        List<File> files = scanner.scan();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public static class FileScanner {

        private final File rootDir;

        public java_13200_FileScanner_A07(File rootDir) {
            this.rootDir = rootDir;
        }

        public List<File> scan() {
            List<File> files = new ArrayList<>();
            scanDir(rootDir, files);
            return files;
        }

        private void scanDir(File dir, List<File> files) {
            File[] dirContents = dir.listFiles();
            if (dirContents != null) {
                for (File file : dirContents) {
                    if (file.isDirectory()) {
                        scanDir(file, files);
                    } else if (file.canRead() && !file.isHidden()) {
                        files.add(file);
                    }
                }
            }
        }
    }
}