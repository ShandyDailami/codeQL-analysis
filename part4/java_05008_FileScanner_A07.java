import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_05008_FileScanner_A07 {

    public static void main(String[] args) {

        File rootDir = new File(".");
        String[] extensions = {".txt", ".jpg", ".png"};

        File[] hiddenFiles = rootDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return false;
            }
        });

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                System.out.println(file.getName());
            }
        }
    }
}