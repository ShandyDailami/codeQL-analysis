import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_11582_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            List<File> fileList = new ArrayList<>();
            getAllFiles(directory, fileList);

            for (File file : fileList) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }

        scanner.close();
    }

    private static void getAllFiles(File directory, List<File> fileList) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileList.add(file);
                } else if (file.isDirectory()) {
                    getAllFiles(file, fileList);
                }
            }
        }
    }
}