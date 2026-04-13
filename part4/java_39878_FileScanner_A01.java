import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_39878_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = ".";
        File dir = new File(directoryPath);
        File[] txtFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        for (File file : txtFiles) {
            System.out.println(file.getName());
        }
    }
}