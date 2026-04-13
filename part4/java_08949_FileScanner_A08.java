import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_08949_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        List<File> textFiles = new ArrayList<>();
        scanFiles(directory, textFiles);

        textFiles.forEach(file -> System.out.println(file.getPath()));
    }

    private static void scanFiles(File directory, List<File> textFiles) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    textFiles.add(file);
                } else if (file.isDirectory()) {
                    scanFiles(file, textFiles);
                }
            }
        }
    }
}