import java.io.File;
import java.util.Scanner;

public class java_07679_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files found in the directory!");
            }
        } else {
            System.out.println("Invalid directory path!");
        }
    }
}