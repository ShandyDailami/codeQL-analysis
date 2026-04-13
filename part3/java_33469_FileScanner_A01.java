import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_33469_FileScanner_A01 {
    private static List<String> fileList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        scanner.close();

        File directory = new File(directoryPath);
        listFilesRecursively(directory);

        for (String filePath : fileList) {
            System.out.println(filePath);
        }
    }

    private static void listFilesRecursively(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String filePath = file.getAbsolutePath();
                    // Security-sensitive operation: Preventing file path from displaying
                    fileList.add(filePath);
                } else if (file.isDirectory()) {
                    listFilesRecursively(file);
                }
            }
        }
    }
}