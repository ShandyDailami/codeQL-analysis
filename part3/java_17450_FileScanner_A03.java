import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_17450_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        String filter = "filter.txt"; // replace with your filter
        findFiles(directory, filter);
    }

    public static void findFiles(String directory, String filter) {
        File root = new File(directory);
        File[] list = root.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().equals(filter);
            }
        });
        if (list != null) {
            for (File file : list) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No file found!");
        }
    }
}