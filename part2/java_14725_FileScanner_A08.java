import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class java_14725_FileScanner_A08 {

    public static List<String> getFilesInDirectory(String directoryPath) {
        List<String> fileNames = new ArrayList<>();

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }
        return fileNames;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        List<String> fileNames = getFilesInDirectory(directoryPath);

        System.out.println("Files in the directory:");
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }
}