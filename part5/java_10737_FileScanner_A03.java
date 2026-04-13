import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_10737_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        List<File> listOfFiles = getFiles(directory);

        for (File file : listOfFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static List<File> getFiles(File directory) {
        List<File> listOfFiles = new ArrayList<>();
        File[] listOfFilesInDirectory = directory.listFiles();

        if (listOfFilesInDirectory != null) {
            for (File file : listOfFilesInDirectory) {
                if (file.isFile()) {
                    listOfFiles.add(file);
                } else if (file.isDirectory()) {
                    listOfFiles.addAll(getFiles(file));
                }
            }
        }

        return listOfFiles;
    }
}