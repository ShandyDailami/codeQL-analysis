import java.io.File;
import java.util.Scanner;

public class java_16457_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
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
                System.out.println("Not a directory");
            }
        } else {
            System.out.println("File does not exist");
        }

        scanner.close();
    }
}