import java.io.File;
import java.util.Scanner;

public class java_00479_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName() + ", Size: " + file.length() + " bytes");
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }

        scanner.close();
    }
}