import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25733_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory";

        File directory = new File(directoryPath);
        File[] directoryContent = directory.listFiles();

        if (directoryContent != null) {
            for (File file : directoryContent) {
                if (file.isFile()) {
                    printFileInfo(file);
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getAbsolutePath());
        System.out.println("File size: " + file.length() + " bytes");
        System.out.println("-------------------------------");
    }
}