import java.io.File;
import java.util.Scanner;

public class java_07782_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The specified directory does not exist!");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Unable to list files in the directory!");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                if (file.canRead()) {
                    System.out.println("File: " + file.getName());
                } else {
                    System.out.println("The file " + file.getName() + " cannot be read!");
                }
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            }
        }
    }
}