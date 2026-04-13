import java.io.File;
import java.util.Scanner;

public class java_39261_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File Name: " + file.getName());
                        System.out.println("File Size: " + file.length() + " bytes");
                    } else if (file.isDirectory()) {
                        System.out.println("Directory Name: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }
}