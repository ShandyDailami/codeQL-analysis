import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_26775_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";
        searchFiles(directory);
    }

    public static void searchFiles(String directory) {
        File file = new File(directory);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // This filter only accepts .txt files
                return name.endsWith(".txt");
            }
        };

        try {
            File[] list = file.listFiles(filter);
            if (list != null) {
                for (File f : list) {
                    if (f.canRead()) {
                        // This operation is security-sensitive, but not harmful
                        System.out.println("Reading file: " + f.getAbsolutePath());
                    } else {
                        System.out.println("Cannot read file: " + f.getAbsolutePath());
                    }
                }
            }
        } catch (SecurityException e) {
            System.out.println("Access denied: " + e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getLocalizedMessage());
        }
    }
}