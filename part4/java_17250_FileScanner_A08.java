import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_17250_FileScanner_A08 {

    private static List<String> fileNames = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        FileScanner fileScanner = new FileScanner();
        fileScanner.scanDirectory(new File(directoryPath));

        for (String fileName : fileNames) {
            System.out.println(fileName);
        }

        scanner.close();
    }

    public void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }
}