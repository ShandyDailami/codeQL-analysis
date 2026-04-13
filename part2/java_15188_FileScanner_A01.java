import java.io.File;
import java.util.Scanner;

public class java_15188_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] list = file.listFiles();
                if (list != null) {
                    for (File f : list) {
                        if (f.isFile() && f.canRead()) {
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
            System.out.println("File not found");
        }

        scanner.close();
    }
}