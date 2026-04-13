import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_05255_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        fileScan(directoryPath);
    }

    private static void fileScan(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().contains("password");
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println("File found: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}