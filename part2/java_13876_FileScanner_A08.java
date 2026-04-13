import java.io.File;
import java.util.Scanner;

public class java_13876_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory size: " + file.listFiles().length);
            } else {
                System.out.println("File size: " + file.length());
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}