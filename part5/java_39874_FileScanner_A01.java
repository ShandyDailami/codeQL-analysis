import java.io.File;
import java.util.Scanner;

public class java_39874_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("File name: " + file.getName());
                        } else if (file.isDirectory()) {
                            System.out.println("Directory name: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("Given path is not a directory");
            }
        } else {
            System.out.println("Given directory does not exist");
        }
    }
}