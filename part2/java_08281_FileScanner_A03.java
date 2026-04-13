import java.io.File;
import java.util.Arrays;

public class java_08281_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory
        File directory = new File(directoryPath);

        listFilesAndDirectories(directory);
    }

    private static void listFilesAndDirectories(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(FileScanner::printFileDetails);
        }

        for (File file : files) {
            if (file.isDirectory()) {
                listFilesAndDirectories(file);
            }
        }
    }

    private static void printFileDetails(File file) {
        if (file.isFile()) {
            System.out.println("File: " + file.getName());
        } else if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());
        }
    }
}