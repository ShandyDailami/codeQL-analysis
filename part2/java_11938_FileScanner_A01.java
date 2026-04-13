import java.io.File;
import java.io.FilenameFilter;

public class java_11938_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Replace with your directory
        String extension = "txt"; // Replace with your extension

        File dir = new File(directory);

        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}