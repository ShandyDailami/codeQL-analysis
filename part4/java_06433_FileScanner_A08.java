import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_06433_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            List<String> filePaths = getFilePaths(directory);
            System.out.println("File paths: " + filePaths);
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }

    private static List<String> getFilePaths(File directory) {
        List<String> filePaths = new ArrayList<>();
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    filePaths.add(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    filePaths.addAll(getFilePaths(file));
                }
            }
        }

        return filePaths;
    }
}