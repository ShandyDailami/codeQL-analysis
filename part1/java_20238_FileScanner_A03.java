import java.io.File;
import java.util.Scanner;

public class java_20238_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory contents:");
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        System.out.println(f.getName());
                    }
                } else {
                    System.out.println("Directory is empty.");
                }
            } else {
                System.out.println("File path is not a directory: " + path);
            }
        } else {
            System.out.println("File path does not exist: " + path);
        }

        scanner.close();
    }
}