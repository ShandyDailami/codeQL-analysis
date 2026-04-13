import java.io.File;
import java.util.Scanner;

public class java_11323_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((dir1, name) -> name.matches(pattern));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found matching the pattern!");
            }
        } else {
            System.out.println("The specified directory does not exist!");
        }

        scanner.close();
    }
}