import java.io.File;
import java.io.FilenameFilter;

public class java_25689_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory path
        listFiles(new File(directory), new FileFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // accept all files, not just directories
                return true;
            }
        });
    }

    private static void listFiles(File directory, FileFilter filter) {
        for (File file : directory.listFiles(filter)) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listFiles(file, filter);
            }
        }
    }
}