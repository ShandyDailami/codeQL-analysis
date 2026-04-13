import java.io.File;
import java.util.Scanner;

public class java_24612_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File Name: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path or it's not a directory.");
        }

        scanner.close();
    }
}