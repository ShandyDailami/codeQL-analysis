import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_30412_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        listFilesWithExtension(directoryPath, ".txt");
    }

    public static void listFilesWithExtension(String directoryPath, String extension) {
        File dir = new File(directoryPath);
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
        } else {
            System.out.println("No files found with extension: " + extension);
        }
    }
}