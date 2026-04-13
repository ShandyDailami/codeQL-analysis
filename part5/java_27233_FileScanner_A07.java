import java.io.File;
import java.io.FileFilter;

public class java_27233_FileScanner_A07 {
    public static void main(String[] args) {
        // Specify your directory here
        String directoryPath = "/path/to/your/directory";

        File directory = new File(directoryPath);

        // Create a file filter to filter out non-file entries
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Accept only files
                return pathname.isFile();
            }
        };

        // List all files in the directory
        listFiles(directory, fileFilter);
    }

    private static void listFiles(File directory, FileFilter fileFilter) {
        File[] files = directory.listFiles(fileFilter);

        if (files == null) {
            return;
        }

        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}