import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_40981_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "path_to_your_directory";

        File dir = new File(directory);

        File[] listOfFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                if (file.isFile() && file.getName().endsWith(".txt") && !file.isHidden() && file.canRead()) {
                    return true;
                }
                return false;
            }
        });

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                try {
                    System.out.println(file.getCanonicalPath());
                } catch (IOException e) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}