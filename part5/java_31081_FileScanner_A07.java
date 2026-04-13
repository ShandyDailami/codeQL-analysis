import java.io.File;
import java.util.Scanner;

public class java_31081_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("File: " + file.getName());
                        } else if (file.isDirectory()) {
                            System.out.println("Directory: " + file.getName());
                        }
                    }
                } else {
                    System.out.println("No files in directory " + directoryPath);
                }
            } else {
                System.out.println(directoryPath + " is not a directory");
            }
        } else {
            System.out.println("No such directory: " + directoryPath);
        }

        scanner.close();
    }
}