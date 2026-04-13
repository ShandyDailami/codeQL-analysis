import java.io.File;
import java.util.Scanner;

public class java_17474_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String dirPath = scanner.next();

        File dir = new File(dirPath);

        if (dir.exists()) {
            if (dir.isDirectory()) {
                String[] files = dir.list();

                if (files != null) {
                    for (String file : files) {
                        System.out.println(file);
                    }
                } else {
                    System.out.println("Path is not a directory");
                }
            } else {
                System.out.println("Path is not a directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }
}