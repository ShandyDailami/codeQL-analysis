import java.io.File;
import java.util.Scanner;

public class java_29718_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}