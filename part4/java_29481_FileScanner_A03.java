import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_29481_FileScanner_A03 {

    public static void main(String[] args) {
        String dir = "/path/to/directory";  // specify your directory here
        File startingDir = new File(dir);

        File[] allFiles = startingDir.listFiles();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}