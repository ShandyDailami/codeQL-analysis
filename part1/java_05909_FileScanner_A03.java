import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_05909_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            List<String> fileNames = listFiles(directory);
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }

    public static List<String> listFiles(File directory) {
        List<String> fileNames = new ArrayList<>();
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                } else if (file.isDirectory()) {
                    fileNames.addAll(listFiles(file));
                }
            }
        }

        return fileNames;
    }
}