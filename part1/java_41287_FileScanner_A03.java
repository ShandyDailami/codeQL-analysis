import java.io.File;
import java.util.List;

public class java_41287_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);
        listFilesRecursively(directory);
    }

    public static void listFilesRecursively(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Print the file name and full path
                    System.out.println("File: " + file.getName() + ", Path: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    // Call listFilesRecursively to list files in subdirectories
                    listFilesRecursively(file);
                }
            }
        }
    }
}