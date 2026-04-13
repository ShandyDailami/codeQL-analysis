import java.io.File;
import java.util.Scanner;

public class java_21194_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            File[] list = dir.listFiles();

            for (int i = 0; i < list.length; i++) {
                if (list[i].isFile()) {
                    System.out.println("File: " + list[i].getName());
                } else if (list[i].isDirectory()) {
                    System.out.println("Directory: " + list[i].getName());
                }
            }
        } else {
            System.out.println("Invalid path or not a directory.");
        }

        scanner.close();
    }
}