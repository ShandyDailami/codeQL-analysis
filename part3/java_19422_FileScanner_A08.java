import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19422_FileScanner_A08 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.startScanning("./target/classes");
    }
}

class FileScanner {
    public void startScanning(String directory) {
        File dir = new File(directory);
        if (dir.exists()) {
            File[] list = dir.listFiles();
            if (list != null) {
                for (File file : list) {
                    if (file.isFile()) {
                        printFileInfo(file);
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getAbsolutePath());
                        startScanning(file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Directory not found: " + directory);
        }
    }

    private void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
        System.out.println("Type: " + file.getName());
        System.out.println("Size: " + file.length() + " bytes");
    }
}