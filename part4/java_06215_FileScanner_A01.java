import java.io.File;
import java.util.Scanner;

public class java_06215_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        File directory = new File(path);
        if (directory.exists()) {
            File[] list = directory.listFiles();
            if (list != null) {
                for (File file : list) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
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