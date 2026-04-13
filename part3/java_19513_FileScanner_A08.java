import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_19513_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        printFilesInDirectory(directory, fileFilter);
    }

    private static void printFilesInDirectory(File directory, FileFilter fileFilter) {
        if (directory.listFiles(fileFilter).length == 0) {
            System.out.println("No files found in the directory.");
        } else {
            for (File file : directory.listFiles(fileFilter)) {
                System.out.println("File found: " + file.getPath());
            }
        }
    }
}