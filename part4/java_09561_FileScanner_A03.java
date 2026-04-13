import java.io.File;
import java.util.Scanner;

public class java_09561_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                listFiles(file, scanner);
            } else {
                System.out.println("File: " + file.getAbsolutePath());
                System.out.println("File size: " + file.length() + " bytes");
            }
        } else {
            System.out.println("The path does not exist.");
        }

        scanner.close();
    }

    private static void listFiles(File directory, Scanner scanner) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    listFiles(file, scanner);
                } else {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }
    }
}