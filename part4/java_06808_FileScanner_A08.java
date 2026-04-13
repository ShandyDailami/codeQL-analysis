import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_06808_FileScanner_A08 {
    private final File file;
    private final String fileName;
    private final String directory;

    public java_06808_FileScanner_A08(String directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;
        this.file = new File(directory, fileName);
    }

    public void scanFile() {
        if (!file.exists()) {
            System.out.println("File " + fileName + " not found");
            return;
        }

        if (file.isDirectory()) {
            System.out.println(fileName + " is a directory");
            return;
        }

        if (!file.canRead()) {
            System.out.println("Cannot read " + fileName);
            return;
        }

        System.out.println("File " + fileName + " found");
    }

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String fileName = "file.txt";
        FileScanner scanner = new FileScanner(directory, fileName);
        scanner.scanFile();
    }
}