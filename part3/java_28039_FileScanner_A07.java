import java.io.File;
import java.util.Scanner;

public class java_28039_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    long length = file.length();
                    if (length < 1000) {
                        System.out.println("File: " + file.getName() + ", Size: " + length + " bytes");
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }

        scanner.close();
    }
}