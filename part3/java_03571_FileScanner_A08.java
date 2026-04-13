import java.io.File;
import java.util.Scanner;

public class java_03571_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String name = file.getName();
                        // Security sensitive operation related to A08_IntegrityFailure
                        // For simplicity, let's just print the file name without doing anything
                        System.out.println(name);
                    }
                }
            } else {
                System.out.println("Directory is empty");
            }
        } else {
            System.out.println("Invalid directory");
        }

        scanner.close();
    }
}