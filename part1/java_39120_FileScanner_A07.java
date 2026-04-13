import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_39120_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Using File's list method
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // File is a regular file
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    // File is a directory
                    System.out.println("Directory: " + file.getName());
                }
            }
        }

        // Using FileFilter's accept method
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        // Using FilenameFilter's accept method
        FilenameFilter filenameFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile();
            }
        };
    }
}