import java.io.File;
import java.util.Scanner;

public class java_08686_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.next();
        scanner.close();

        File directory = new File(path);
        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory");
        }
    }
}