import java.io.File;
import java.util.Scanner;

public class java_38277_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        long size = file.length();
                        System.out.println("File: " + file.getName() + ", Size: " + size + " bytes");
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }
}