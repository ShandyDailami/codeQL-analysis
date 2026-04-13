import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_02482_FileScanner_A03 {

    public static void main(String[] args) {
        File rootDirectory = new File(".");

        File[] hiddenFiles = rootDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println("Hidden file found: " + file.getPath());
                }
            }
        }
    }
}