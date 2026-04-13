import java.io.File;
import java.io.FilenameFilter;
import java.io.FileFilter;

public class java_13112_FileScanner_A01 {
    private String directoryPath;
    private String extension;

    public java_13112_FileScanner_A01(String directoryPath, String extension) {
        this.directoryPath = directoryPath;
        this.extension = extension;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.getName().toLowerCase().endsWith(extension.toLowerCase());
            }
        };

        File[] files = directory.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("/path/to/directory", ".txt");
        scanner.scanDirectory();
    }
}