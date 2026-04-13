import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_11421_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Create a FileFilter to filter out all files that start with '.'
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.getName().startsWith(".");
            }
        };

        // Use the recursive method to list all files in the directory
        listFilesRecursively(directory, fileFilter);
    }

    private static void listFilesRecursively(File root, FileFilter fileFilter) {
        File[] files = root.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFilesRecursively(file, fileFilter);
                } else {
                    System.out.println(file.getPath());
                }
            }
        }
    }
}