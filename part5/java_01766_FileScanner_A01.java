import java.io.File;
import java.util.Scanner;

public class java_01766_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        } else {
            System.out.println("No files or directories found in the specified directory.");
        }

        scanner.close();
    }
}