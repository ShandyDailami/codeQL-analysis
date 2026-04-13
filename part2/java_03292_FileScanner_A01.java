import java.io.File;
import java.util.Scanner;

public class java_03292_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();

        File file = new File(path);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String s : list) {
                    System.out.println(s);
                }
            } else {
                System.out.println("Error: " + file.getAbsolutePath() + " is not a directory");
            }
        } else {
            System.out.println("Error: " + file.getAbsolutePath() + " is not a directory");
        }
    }
}