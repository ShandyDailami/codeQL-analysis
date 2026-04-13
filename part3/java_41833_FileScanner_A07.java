import java.io.File;
import java.io.FileFilter;

public class java_41833_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // specify the directory path
        String fileExtension = ".txt"; // specify the file extension

        File directory = new File(directoryPath);

        File[] allFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(fileExtension);
            }
        });

        if (allFiles != null) {
            for (File file : allFiles) {
                System.out.println("File found: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found in the specified directory and its subdirectories");
        }
    }
}