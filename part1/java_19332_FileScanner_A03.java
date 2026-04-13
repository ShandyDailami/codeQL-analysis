import java.io.File;
import java.util.Scanner;

public class java_19332_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();

        System.out.println("Enter the extension to filter files by (leave blank for all files):");
        String fileExtension = scanner.nextLine();

        for (File file : listOfFiles) {
            if (file.isFile() && (fileExtension.equals("") || file.getName().endsWith(fileExtension))) {
                System.out.println("File Name: " + file.getName());
            }
        }

        scanner.close();
    }
}