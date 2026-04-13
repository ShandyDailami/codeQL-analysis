import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_40595_FileScanner_A07 {

    public static void main(String[] args) {
        String dir = "/path/to/directory"; // Replace with your directory
        String extension = "txt"; // Replace with your extension

        File root = new File(dir);

        fileInDirectory(root, extension);
    }

    private static void fileInDirectory(File dir, String extension) {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }

        File[] subdirs = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (subdirs != null) {
            for (File subdir : subdirs) {
                fileInDirectory(subdir, extension);
            }
        }
    }
}