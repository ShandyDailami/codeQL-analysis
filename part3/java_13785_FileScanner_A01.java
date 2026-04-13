import java.io.File;
import java.io.FilenameFilter;

public class java_13785_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";  // provide a directory path here
        scanDirectory(directoryPath);
    }

    private static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("Directory is not readable.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files in directory.");
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file.getPath());
            } else {
                System.out.println("File: " + file.getPath());
            }
        }
    }
}