import java.io.File;
import java.util.Scanner;

public class java_01064_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();

        File directory = new File(path);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File name: " + file.getName());
                    System.out.println("File size: " + file.length() + " bytes");
                    System.out.println("File path: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory name: " + file.getName());
                }
            }
        } else {
            System.out.println("The directory is empty!");
        }

        scanner.close();
    }
}