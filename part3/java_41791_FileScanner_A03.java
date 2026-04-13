import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_41791_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "."; // current directory

        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.getName().equals("target");
            }
        };

        File[] files = directory.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                System.out.println("Full file path: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found named 'target' in directory " + directoryPath);
        }
    }
}