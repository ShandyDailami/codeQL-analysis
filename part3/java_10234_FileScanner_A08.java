import java.io.File;
import java.util.Scanner;

public class java_10234_FileScanner_A08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                   
                    }
                }
            } else {
                System.out.println("No files or directories in this directory.");
            }
        } else {
            System.out.println("Invalid path.");
        }
    }
}