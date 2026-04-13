import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_27755_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        FileScanner fileScanner = new FileScanner(directoryPath);
        List<String> fileNames = fileScanner.getFileNames();

        System.out.println("File names:");
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }
}

class FileScanner {
    private String directoryPath;

    public java_27755_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public List<String> getFileNames() {
        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();
        List<String> fileNames = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                fileNames.add(listOfFiles[i].getName());
            }
        }

        return fileNames;
    }
}