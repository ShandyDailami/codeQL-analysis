import java.io.File;
import java.util.Scanner;

public class java_39254_FileScanner_A07 {
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
                        if (f.isFile()) {
                            System.out.println("File: " + f.getName());
                        } else if (f.isDirectory()) {
                            System.out.println("Directory: " + f.getName());
                        }
                    }
                }
            } else {
                System.out.println("The given path is not a directory");
            }
        } else {
            System.out.println("The given path does not exist");
        }

        scanner.close();
    }
}