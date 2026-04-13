import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00810_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("The entered path is not a directory!");
            return;
        }

        try {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (!file.isHidden()) {
                        long fileSize = file.length();
                        String fileName = file.getName();
                        System.out.println("File name: " + fileName);
                        System.out.println("File size: " + fileSize);
                        System.out.println("--------------------------");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        scanner.close();
    }
}