import java.io.File;
import java.util.Scanner;

public class java_36621_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        printFilesInDirectory(new File(path));
    }

    private static void printFilesInDirectory(File directory) {
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    printFilesInDirectory(file);
                }
            }
        }
    }
}