import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02774_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // This is a security-sensitive operation, please don't do this.
                    System.out.println("File name: " + file.getName());
                }
            }
        }
    }
}