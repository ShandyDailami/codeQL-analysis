import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_17645_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        List<File> filesInDirectory = new ArrayList<>();
        getAllFiles(directory, filesInDirectory);

        System.out.println("Enter a file name to search for:");
        String fileName = scanner.nextLine();

        if (filesInDirectory.contains(new File(fileName))) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }

    private static void getAllFiles(File directory, List<File> filesInDirectory) {
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    filesInDirectory.add(file);
                } else if (file.isDirectory()) {
                    getAllFiles(file, filesInDirectory);
                }
            }
        }
    }
}