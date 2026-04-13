import java.io.File;
import java.io.FileFilter;

public class java_39182_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory
        String extension = "txt"; // replace with your extension

        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                // process file here
                System.out.println("Processing file: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with extension: " + extension);
        }
    }
}