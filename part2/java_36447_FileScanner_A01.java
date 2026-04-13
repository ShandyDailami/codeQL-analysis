import java.io.File;
import java.io.FilenameFilter;

public class java_36447_FileScanner_A01 implements FilenameFilter {

    private String[] fileNames;
    private File directory;

    public java_36447_FileScanner_A01(String directoryPath) {
        this.directory = new File(directoryPath);
    }

    public void findFiles(String extension) {
        fileNames = directory.list(this, ".*\\." + extension);
    }

    public void printFileNames() {
        if (fileNames != null) {
            for (String name : fileNames) {
                System.out.println(name);
            }
        } else {
            System.out.println("No files found with extension " + extension);
        }
    }

    @Override
    public boolean accept(File dir, String name) {
        return true;
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("/path/to/directory");
        scanner.findFiles("txt");
        scanner.printFileNames();
    }
}