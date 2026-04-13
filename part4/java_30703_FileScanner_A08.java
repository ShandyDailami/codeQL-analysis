import java.io.File;
import java.util.Scanner;

public class java_30703_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile() && f.getName().endsWith(".txt")) {
                        System.out.println("File: " + f.getName());
                    } else if (f.isDirectory()) {
                        System.out.println("Directory: " + f.getName());
                    }
                }
            }
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }

        scanner.close();
    }
}