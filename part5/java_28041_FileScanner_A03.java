import java.io.File;
import java.util.Scanner;

public class java_28041_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File name: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory name: " + file.getName());
                }
            }
        } else {
            System.out.println("No files or directories found!");
        }
    }
}