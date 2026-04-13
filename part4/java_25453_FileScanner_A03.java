import java.io.File;
import java.util.Scanner;

public class java_25453_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                String[] files = directory.list();
                if (files != null) {
                    for (String fileName : files) {
                        File file = new File(directoryPath + "/" + fileName);
                        if (file.isFile()) {
                            System.out.println(fileName);
                        }
                    }
                } else {
                    System.out.println("No files in directory.");
                }
            } else {
                System.out.println("Not a directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}