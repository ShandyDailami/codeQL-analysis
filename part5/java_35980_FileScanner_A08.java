import java.io.File;
import java.io.FileFilter;

public class java_35980_FileScanner_A08 {

    public static void main(String[] args) {
        File startDirectory = new File("your/directory/here");
        long minSize = 100; // Set minimum size of files to scan

        FileScanner scanner = new FileScanner(startDirectory, minSize);
        scanner.filterFiles();
    }
}

class FileScanner {

    private File startDirectory;
    private long minSize;

    public java_35980_FileScanner_A08(File startDirectory, long minSize) {
        this.startDirectory = startDirectory;
        this.minSize = minSize;
    }

    public void filterFiles() {
        File[] foundFiles = startDirectory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.length() > minSize;
            }
        });

        if (foundFiles != null) {
            for (File file : foundFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found in directory!");
        }
    }
}