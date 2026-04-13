import java.io.File;
import java.util.Scanner;

public class java_23998_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            System.out.println("File: " + file.getName() + ", Size: " + file.length() + " bytes");
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}