import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_37152_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        List<File> files = new ArrayList<>();
        getFiles(directory, files);

        System.out.println("Files in directory:");
        for (File file : files) {
            System.out.println(file.getPath());
        }
    }

    private static void getFiles(File directory, List<File> files) {
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    getFiles(file, files);
                }
            }
        }
    }
}