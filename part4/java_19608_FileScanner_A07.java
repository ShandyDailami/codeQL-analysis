import java.io.File;
import java.util.Scanner;

public class java_19608_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files in directory!");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            }
        }

        scanner.close();
    }
}