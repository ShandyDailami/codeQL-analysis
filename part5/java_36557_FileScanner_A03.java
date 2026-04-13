import java.io.File;
import java.util.Scanner;

public class java_36557_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();
        scanner.close();

        File file = new File(path);

        if (file.exists() && file.isDirectory()) {
            File[] list = file.listFiles();
            for (File f : list) {
                if (f.isFile()) {
                    if (f.getName().endsWith(".txt")) {
                        System.out.println("File: " + f.getName());
                    }
                } else {
                    System.out.println("Directory: " + f.getName());
                }
            }
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }
    }
}