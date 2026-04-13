import java.io.File;
import java.util.ArrayList;

public class java_11330_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory);
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }

    private static void listFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    listFiles(file);
                }
            }
        }
    }
}