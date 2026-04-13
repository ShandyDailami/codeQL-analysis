import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_05218_FileScanner_A08 {

    public static void main(String[] args) {
        File root = new File(".");
        String ext = "txt";

        File[] list = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(ext);
            }
        });

        if (list != null) {
            for (File file : list) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No " + ext + " files found.");
        }
    }
}