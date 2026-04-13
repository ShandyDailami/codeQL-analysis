import java.io.File;
import java.util.Scanner;

public class java_08238_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File file = new File(dirPath);

        if (file.exists() && file.isDirectory()) {
            listFiles(file, scanner);
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }

    private static void listFiles(File dir, Scanner scanner) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    listFiles(file, scanner);
                }
            }
        }
    }
}