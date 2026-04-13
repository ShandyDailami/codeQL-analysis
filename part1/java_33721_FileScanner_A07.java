import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_33721_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File("src");
        File[] result = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (result != null) {
            for (File file : result) {
                System.out.println(file.getName());
            }
        }
    }

}