import java.io.File;
import java.util.Scanner;

public class java_08940_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    long length = file.length();
                    if (length > 100) {
                        System.out.println("File: " + file.getName() + ", Length: " + length);
                    }
                }
            }
        }

        scanner.close();
    }
}