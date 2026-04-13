import java.io.File;
import java.util.Scanner;

public class java_28703_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Given path does not exist as a directory.");
        }

        scanner.close();
    }
}