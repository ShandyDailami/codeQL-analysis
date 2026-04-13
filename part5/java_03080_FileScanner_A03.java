import java.io.File;
import java.util.Scanner;

public class java_03080_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = input.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File Name: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory Name: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files in directory " + directoryPath);
            }
        } else {
            System.out.println("Directory " + directoryPath + " does not exist.");
        }
    }
}