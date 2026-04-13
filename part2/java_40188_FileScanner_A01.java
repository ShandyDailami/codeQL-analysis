import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40188_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Directory contents:");
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("Directory is empty!");
            }
        } else {
            System.out.println("Invalid directory or directory does not exist!");
        }

        scanner.close();
    }
}