import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_41976_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\username\\Downloads"; // Please replace with your directory path
        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return true;
            }
        };

        listFiles(directory, filter);
    }

    private static void listFiles(File directory, FilenameFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, filter);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}