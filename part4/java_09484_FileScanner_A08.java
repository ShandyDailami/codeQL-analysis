import java.io.File;
import java.io.FilenameFilter;

public class java_09484_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        listFiles(directory, null);
    }

    public static void listFiles(File directory, FilenameFilter filter) {
        File[] files = directory.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, null);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}