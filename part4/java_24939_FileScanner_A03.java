import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24939_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            System.exit(1);
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files in directory");
            System.exit(1);
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            }
        }

        scanner.close();
    }
}