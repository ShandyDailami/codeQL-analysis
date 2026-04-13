import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17538_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            String[] directoryContents = directory.list();
            for (String fileName : directoryContents) {
                File file = new File(directoryPath + "/" + fileName);
                if (file.isFile()) {
                    printFileInfo(fileName, file.length());
                }
            }
        } else {
            printFileInfo(directoryPath, directory.length());
        }
    }

    private static void printFileInfo(String fileName, long fileSize) {
        System.out.println("File: " + fileName + ", Size: " + fileSize + " bytes");
    }
}