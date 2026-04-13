import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_32695_FileScanner_A07 {

    public static void main(String[] args) {
        String dirPath = "/path/to/your/directory";  // replace with your directory path
        String extension = "\\.txt$";  // regular expression for .txt files

        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] txtFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().matches(extension);
            }
        });

        if (txtFiles == null) {
            System.out.println("No .txt files found in the directory");
            return;
        }

        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getName());
        }
    }
}