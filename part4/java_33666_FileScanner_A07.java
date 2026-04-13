import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_33666_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";  // replace with your directory path

        File dir = new File(directory);

        File[] txtFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getName());
            }
        }
    }
}