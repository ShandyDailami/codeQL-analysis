import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09928_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("Directory does not exist or no read permissions.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}