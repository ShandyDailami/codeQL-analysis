import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_21805_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        String extension = ".java"; // replace with your extension

        File directory = new File(directoryPath);

        File[] result = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (result == null) {
            System.out.println("No files found with extension: " + extension);
        } else {
            System.out.println("Found " + result.length + " files with extension: " + extension);
            for (File file : result) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}