import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02229_FileScanner_A01 {
    private String directoryPath;

    public java_02229_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println(file.getName());
                        } else {
                            System.out.println("Directory: " + file.getName());
                            scanDirectory();
                        }
                    }
                }
            } else {
                System.out.println("Provided path is not a directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileScanner scanner = new FileScanner("C:\\Users\\YourUsername\\YourDirectory"); // Replace with your directory path
        scanner.scanDirectory();
    }
}