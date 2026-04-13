import java.io.File;
import java.util.Arrays;

public class java_27075_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // Replace with your directory path
        scanDirectory(new File(directoryPath));
    }

    public static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(FileScanner::printFileInfo);
        }
    }

    public static void printFileInfo(File file) {
        if (file.isFile()) {
            System.out.println("File: " + file.getName());
            System.out.println("Size: " + file.length() + " bytes");
        } else if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());
            scanDirectory(file);
        }
    }
}