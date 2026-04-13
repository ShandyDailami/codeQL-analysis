import java.io.File;
import java.io.FileFilter;

public class java_04759_FileScanner_A08 {

    private final File rootDirectory;

    public java_04759_FileScanner_A08(File rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public void scan(String extension) {
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        };
        scan(rootDirectory, filter);
    }

    private void scan(File directory, FileFilter filter) {
        File[] foundFiles = directory.listFiles(filter);
        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isDirectory()) {
                    scan(file, filter);
                } else {
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        File rootDirectory = new File("path_to_your_directory");
        new FileScanner(rootDirectory).scan(".txt");
    }
}