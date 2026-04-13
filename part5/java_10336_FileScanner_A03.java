import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_10336_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().startsWith(".")) {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }

        scanner.close();
    }
}