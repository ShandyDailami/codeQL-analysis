import java.io.File;
import java.util.Scanner;

public class java_38375_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }

        scanner.close();
    }
}