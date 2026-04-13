import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_20477_FileScanner_A08 {
    public static void main(String[] args) {
        File dir = new File(".");
        File[] hiddenFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.isFile()) {
                    if (hiddenFile.getName().equals("A08_IntegrityFailure")) {
                        System.out.println("Found hidden file: " + hiddenFile.getPath());
                    }
                }
            }
        }
    }
}