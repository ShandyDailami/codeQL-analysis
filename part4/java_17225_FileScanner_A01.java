import java.io.File;
import java.util.Scanner;

public class java_17225_FileScanner_A01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to directory:");
        String path = scanner.nextLine();

        FileScanner fileScanner = new FileScanner();
        fileScanner.scanDirectory(path);
    }
}

class FileScanner {

    public void scanDirectory(String path) {
        File directory = new File(path);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}