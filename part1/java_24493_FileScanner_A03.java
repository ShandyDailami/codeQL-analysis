import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_24493_FileScanner_A03 {
    public static void main(String[] args) {
        String dirPath = "/path/to/dir"; // replace with your directory path
        File dir = new File(dirPath);

        File[] txtFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getAbsolutePath());
            }
        }
    }
}