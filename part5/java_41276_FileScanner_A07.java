import java.io.File;
import java.util.Scanner;

public class java_41276_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.next();

        File directory = new File(path);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files in directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

}