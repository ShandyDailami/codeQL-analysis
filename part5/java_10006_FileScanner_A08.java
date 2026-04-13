import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_10006_FileScanner_A08 implements FileFilter {

    private String[] extensions;
    private String directory;

    public java_10006_FileScanner_A08(String directory, String[] extensions) {
        this.directory = directory;
        this.extensions = extensions;
    }

    @Override
    public boolean accept(File path) {
        for (String extension : extensions) {
            if (path.getName().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String directory = "/path/to/your/directory";
        String[] extensions = {".txt"};
        SecurityAwareFileScanner scanner = new SecurityAwareFileScanner(directory, extensions);
        File[] files = new File(directory).listFiles(scanner);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}