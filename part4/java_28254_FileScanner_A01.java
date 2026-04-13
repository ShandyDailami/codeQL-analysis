import java.io.File;
import java.util.Scanner;

public class java_28254_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);
        if (file.exists()) {
            File[] list = file.listFiles();
            if (list != null) {
                for (File f : list) {
                    if (f.isFile()) {
                        System.out.println("File: " + f.getName());
                    } else if (f.isDirectory()) {
                        System.out.println("Directory: " + f.getName());
                    }
                }
            } else {
                System.out.println("No files in directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }
}