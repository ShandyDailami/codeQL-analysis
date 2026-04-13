import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_21976_FileScanner_A08 {

    private static List<String> fileList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        scanner.close();

        File directory = new File(directoryPath);
        fileList.add(directoryPath);

        if (directory.exists()) {
            scanDirectory(directory);
            printList();
        } else {
            System.out.println("Invalid directory path");
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    fileList.add(file.getAbsolutePath());
                    scanDirectory(file);
                } else if (file.isFile()) {
                    fileList.add(file.getAbsolutePath());
                }
            }
        }
    }

    private static void printList() {
        for (String filePath : fileList) {
            System.out.println(filePath);
        }
    }
}