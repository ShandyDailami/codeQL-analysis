import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_00957_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                List<File> fileList = new ArrayList<>();
                for (File file : files) {
                    if (file.isFile() && !file.getName().startsWith(".")) {
                        fileList.add(file);
                    }
                }

                for (File file : fileList) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No files in the directory!");
            }
        } else {
            System.out.println("Invalid directory!");
        }

        scanner.close();
    }
}