import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_21934_FileScanner_A08 implements FileFilter {

    @Override
    public boolean accept(File path) {
        if (path.isDirectory()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        File rootDir = new File(".");
        File[] hiddenFiles = rootDir.listFiles(new FileFilter() {
            public boolean accept(File path) {
                return path.isHidden();
            }
        });
        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}