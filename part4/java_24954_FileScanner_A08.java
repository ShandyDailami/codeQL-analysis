import java.io.File;
import java.util.Scanner;

public class java_24954_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.nextLine();

        File dir = new File(dirPath);

        File[] files = dir.listFiles((dir1, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}