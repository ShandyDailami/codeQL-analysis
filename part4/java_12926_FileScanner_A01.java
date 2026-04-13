import java.io.File;
import java.util.Scanner;

public class java_12926_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExt = scanner.nextLine();

        File directory = new File(dirPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExt));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with that extension!");
        }

        scanner.close();
    }
}