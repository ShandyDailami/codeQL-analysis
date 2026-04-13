import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18556_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        System.out.println("Directory contents:");
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                    System.out.println("Size: " + file.length() + " bytes");
                }
            }
        }

        scanner.close();
    }
}