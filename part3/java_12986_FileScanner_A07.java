import java.io.File;
import java.util.Scanner;

public class java_12986_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println(file.getName());
                        }
                    }
                }
            } else {
                System.out.println("Please enter a valid directory path");
            }
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }
}