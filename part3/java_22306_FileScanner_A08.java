import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_22306_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("The given directory does not exist!");
            return;
        }

        List<File> textFiles = new ArrayList<>();
        scanFiles(directory, textFiles, ".txt");

        for (File file : textFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void scanFiles(File directory, List<File> textFiles, String extension) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    textFiles.add(file);
                } else if (file.isDirectory()) {
                    scanFiles(file, textFiles, extension);
                }
            }
        }
    }
}