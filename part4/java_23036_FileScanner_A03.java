import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_23036_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path

        File directory = new File(directoryPath);

        File[] hiddenFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        for (File file : hiddenFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }
}