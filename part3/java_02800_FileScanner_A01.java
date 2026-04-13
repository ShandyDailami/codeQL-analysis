import java.io.File;
import java.util.Scanner;

public class java_02800_FileScanner_A01 {

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner();
        fileScanner.scanDirectory(".", true);
    }

}

class FileScanner {

    private void scanDirectory(String directoryPath, boolean recursive) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (recursive) {
                        scanDirectory(file.getPath(), recursive);
                    }
                } else {
                    printFileInfo(file);
                }
            }
        }
    }

    private void printFileInfo(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("File size: " + file.length() + " bytes");
    }

}