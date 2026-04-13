import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_15912_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        String extension = ".txt"; // Replace with your file extension

        File directory = new File(directoryPath);

        // Using a FileFilter
        File[] txtFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        // Using a FilenameFilter
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        });

        // Printing the files
        for (File file : txtFiles) {
            System.out.println(file.getAbsolutePath());
        }
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}