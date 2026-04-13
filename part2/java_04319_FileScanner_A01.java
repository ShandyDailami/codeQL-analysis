import java.io.File;
import java.util.Scanner;

public class java_04319_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((dir1, name) -> name.endsWith(fileName));

            if (files != null) {
                for (File file : files) {
                    System.out.println("File found: " + file.getAbsolutePath());
                }
            } else {
                System.out.println("No files found with the name: " + fileName);
            }
        } else {
            System.out.println("The provided directory does not exist or is not a directory");
        }

        scanner.close();
    }
}