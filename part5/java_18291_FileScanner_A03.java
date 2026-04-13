import java.io.File;
import java.io.FilenameFilter;

public class java_18291_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                listFiles(directory);
            } else {
                System.out.println("Not a directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }

    private static void listFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file);
                } else {
                    System.out.println(file.getPath());
                }
            }
        }
    }
}