import java.io.File;
import java.util.Scanner;

public class java_39411_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        File dir = new File(path);
        if (dir.isDirectory()) {
            String[] files = dir.list();
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("Invalid path or it's not a directory.");
        }

        scanner.close();
    }
}