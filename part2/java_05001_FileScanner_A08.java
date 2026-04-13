import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_05001_FileScanner_A08 implements FileFilter {
    private String directory;

    public java_05001_FileScanner_A08(String directory) {
        this.directory = directory;
    }

    public void listFiles() {
        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().startsWith(".");
            }
        });
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("/path/to/directory");
        scanner.listFiles();
    }
}