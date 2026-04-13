import java.io.File;
import java.util.Scanner;

public class java_14854_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the search string: ");
        String searchString = scanner.nextLine();

        FileScanner scannerInstance = new FileScanner(directoryPath, searchString);
        scannerInstance.scanDirectory();
    }
}

class FileScanner {
    private String directoryPath;
    private String searchString;

    public java_14854_FileScanner_A08(String directoryPath, String searchString) {
        this.directoryPath = directoryPath;
        this.searchString = searchString;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().contains(searchString)) {
                    System.out.println("File: " + file.getPath());
                }
            }
        }
    }
}