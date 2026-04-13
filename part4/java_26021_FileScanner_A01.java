import java.io.File;
import java.util.Scanner;

public class java_26021_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        if (!directory.exists()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Unable to list files in the directory");
        }
    }
}