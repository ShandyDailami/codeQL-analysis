import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03078_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}