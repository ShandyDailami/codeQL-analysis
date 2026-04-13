import java.io.File;
import java.util.Scanner;

public class java_15087_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
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
                System.out.println("No files or directories found in the given path.");
            }
        } else {
            System.out.println("The provided path is not a valid directory.");
        }
        scanner.close();
    }
}