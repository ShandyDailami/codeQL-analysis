import java.io.File;
import java.util.Scanner;

public class java_09673_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists()) {
            File[] list = dir.listFiles();

            if (list != null) {
                for (File file : list) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files or directories found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}