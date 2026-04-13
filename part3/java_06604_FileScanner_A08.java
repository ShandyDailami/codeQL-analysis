import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_06604_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory");
            return;
        }

        System.out.println("Enter file name to search:");
        String fileName = scanner.nextLine();

        List<File> fileList = new ArrayList<>();
        searchFiles(directory, fileName, fileList);

        System.out.println("Found " + fileList.size() + " files:");
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void searchFiles(File directory, String fileName, List<File> fileList) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    fileList.add(file);
                } else if (file.isDirectory()) {
                    searchFiles(file, fileName, fileList);
                }
            }
        }
    }
}