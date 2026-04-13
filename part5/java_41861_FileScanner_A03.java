import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41861_FileScanner_A03 {

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner();
        fileScanner.startScanning("/home/user/documents");
    }

}

class FileScanner {

    private static final String DATA_DIRECTORY = "/home/user/documents";

    public void startScanning(String directory) {
        File file = new File(directory);
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    startScanning(f.getPath());
                } else {
                    printFileInfo(f);
                }
            }
        }
    }

    private void printFileInfo(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getPath());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Last Modified: " + file.lastModified());
        System.out.println("---------------------");
    }
}