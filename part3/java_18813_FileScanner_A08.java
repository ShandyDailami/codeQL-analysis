import java.io.File;
import java.util.Scanner;

public class java_18813_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Directory does not exist or is not accessible: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }

        scanner.close();
    }
}