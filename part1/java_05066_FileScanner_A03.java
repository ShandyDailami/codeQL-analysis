import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_05066_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // replace with your directory path
        scanDirectory(directoryPath);
    }

    private static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("Directory cannot be read");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        System.out.println("Files in directory: " + files.length);

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            }
        }
    }
}