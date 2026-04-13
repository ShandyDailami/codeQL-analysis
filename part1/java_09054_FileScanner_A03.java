import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class java_09054_FileScanner_A03 {
    public static void main(String[] args) {
        File dir = new File(".");
        FileScanner scanner = new FileScanner(dir, new String[]{"."});
        List<File> files = scanner.getMatchingFiles();
        for (File file : files) {
            System.out.println("Found file: " + file.getAbsolutePath());
        }
    }
}

class FileScanner {
    private File dir;
    private String[] extensions;

    public java_09054_FileScanner_A03(File dir, String[] extensions) {
        this.dir = dir;
        this.extensions = extensions;
    }

    public List<File> getMatchingFiles() {
        return Arrays.asList(dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return accept(pathname, dir);
            }

            private boolean accept(File pathname, File parent) {
                // No file or directory name starts with a dot, 
                // file or directory name is not a extension, 
                // or the directory name is not in the file name.
                // We use a regular expression for checking the file name extension.
                return pathname.getName().matches("^[^.]+")
                    && !pathname.isHidden()
                    && (extensions == null || Arrays.asList(extensions).contains(pathname.getPath().substring(parent.getPath().length())));
            }
        }));
    }
}