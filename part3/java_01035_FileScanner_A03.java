import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_01035_FileScanner_A03 {
    public static void main(String[] args) {
        File currentDir = new File(".");
        FileScanner fileScanner = new FileScanner(currentDir);
        fileScanner.scan(".txt");
    }
}

class FileScanner {
    private File currentDir;

    public java_01035_FileScanner_A03(File currentDir) {
        this.currentDir = currentDir;
    }

    public void scan(String extension) {
        File[] files = this.currentDir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}