import java.io.File;
import java.util.Scanner;

public class java_18520_FileScanner_A03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File Name: " + file.getName());
                        System.out.println("Absolute Path: " + file.getAbsolutePath());
                        System.out.println("Last Modified: " + file.lastModified());
                        System.out.println("-------------------------");
                    } else if (file.isDirectory()) {
                        System.out.println("Directory Name: " + file.getName());
                        System.out.println("Absolute Path: " + file.getAbsolutePath());
                        System.out.println("-------------------------");
                    }
                }
            }
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }
}