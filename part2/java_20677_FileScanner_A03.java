import java.io.File;
import java.util.Scanner;

public class java_20677_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner fs = new FileScanner();
        fs.start(".");
    }
}

class FileScanner {
    public void start(String directory) {
        File root = new File(directory);
        File[] list = root.listFiles();

        if (list == null) {
            System.out.println("No files found!");
            return;
        }

        for (File file : list) {
            if (file.isFile()) {
                printFile(file);
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                start(file.getAbsolutePath());
            }
        }
    }

    private void printFile(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}