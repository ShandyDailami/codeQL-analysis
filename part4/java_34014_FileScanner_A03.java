import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_34014_FileScanner_A03 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory("/path/to/directory"); // replace with your directory
    }

}

class FileScanner {

    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                }
            }
        }
    }

    private void printFileInfo(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());
        System.out.println("File size: " + file.length() + " bytes");
    }

}