import java.io.File;
import java.io.FilenameFilter;

public class java_21457_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "C:\\test"; // replace with your directory
        File dir = new File(directory);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return true; // accept all files
            }
        };

        getFiles(dir, filter);
    }

    private static void getFiles(File directory, FilenameFilter filter) {
        File[] list = directory.listFiles(filter);

        if (list == null) {
            return;
        }

        for (File file : list) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                getFiles(file, filter);
            }
        }
    }
}