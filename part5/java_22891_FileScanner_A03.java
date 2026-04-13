import java.io.File;
import java.util.Scanner;

public class java_22891_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                String[] list = file.list();
                for (String s : list) {
                    System.out.println(s);
                }
            } else {
                System.out.println("Given path is not a directory");
            }
        } else {
            System.out.println("Given directory does not exist");
        }
    }
}