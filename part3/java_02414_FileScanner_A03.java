import java.io.File;
import java.io.FilenameFilter;

public class java_02414_FileScanner_A03 {

    // The directory to scan
    private static final String DIRECTORY = "C:\\path\\to\\directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        // Use a FileFilter to scan only .txt files
        FilenameFilter txtFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        // Use a FileFilter to scan only directories
        FilenameFilter dirFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !name.toLowerCase().endsWith(".txt");
            }
        };

        listFiles(directory, txtFilter);
        listFiles(directory, dirFilter);
    }

    private static void listFiles(File directory, FilenameFilter filter) {
        File[] list = directory.listFiles(filter);

        if (list == null) {
            return;
        }

        for (File file : list) {
            if (file.isFile()) {
                System.out.println("Found file: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println("Found directory: " + file.getAbsolutePath());
                listFiles(file, filter);
            }
        }
    }
}