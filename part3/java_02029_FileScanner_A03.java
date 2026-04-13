import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_02029_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "src";

        File startingDirectory = new File(directory);

        File[] txtFiles = startingDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getName());
        }
    }
}