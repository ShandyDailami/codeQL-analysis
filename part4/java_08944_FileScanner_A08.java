import java.io.File;
import java.util.Scanner;

public class java_08944_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile() && file.getName().endsWith(".txt")) {
                            System.out.println("File name: " + file.getName());
                            System.out.println("File size: " + file.length() + " bytes");
                        }
                    }
                } else {
                    System.out.println("No files found in directory.");
                }
            } else {
                System.out.println("Entered path is not a directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}