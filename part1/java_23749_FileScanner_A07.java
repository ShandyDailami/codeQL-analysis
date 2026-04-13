import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_23749_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory";  // specify your directory here
        File directory = new File(directoryPath);

        FilenameFilter txtFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        listFiles(directory, txtFilter);
    }

    private static void listFiles(File directory, FilenameFilter filter) throws IOException {
        File[] files = directory.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    listFiles(file, filter);
                }
            }
        }
    }
}