import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_29496_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension (e.g., .txt):");
        String extension = scanner.nextLine();

        File directory = new File(directoryPath);
        List<File> txtFiles = new ArrayList<>();

        scanFiles(directory, extension, txtFiles);

        System.out.println("Found the following .txt files:");
        for (File file : txtFiles) {
            System.out.println(file.getPath());
        }
    }

    private static void scanFiles(File directory, String extension, List<File> txtFiles) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    txtFiles.add(file);
                } else if (file.isDirectory()) {
                    scanFiles(file, extension, txtFiles);
                }
            }
        }
    }
}