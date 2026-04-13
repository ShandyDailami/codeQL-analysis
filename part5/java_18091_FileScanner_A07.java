import java.io.File;
import java.util.Scanner;

public class java_18091_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    long length = file.length();
                    if (length > 1000000) {
                        System.out.println("Large file: " + file.getName() + ", length: " + length);
                    } else {
                        System.out.println("Small file: " + file.getName() + ", length: " + length);
                    }
                }
            }
        }
    }
}