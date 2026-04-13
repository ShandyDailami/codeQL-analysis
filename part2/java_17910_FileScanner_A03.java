import java.io.File;
import java.util.Scanner;

public class java_17910_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the string to exclude: ");
        String excludeString = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();

            for (String file : files) {
                if (!file.contains(excludeString)) {
                    System.out.println(file);
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }
}