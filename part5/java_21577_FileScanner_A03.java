import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21577_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File length: " + file.length() + " bytes");
                        System.out.println();
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }
}