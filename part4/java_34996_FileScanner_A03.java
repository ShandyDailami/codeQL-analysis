import java.io.File;
import java.util.Scanner;

public class java_34996_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);
        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}