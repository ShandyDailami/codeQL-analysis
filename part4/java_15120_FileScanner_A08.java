import java.io.File;
import java.util.Arrays;

public class java_15120_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "./src";  // Replace this with your directory path
        File directory = new File(directoryPath);

        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }
}