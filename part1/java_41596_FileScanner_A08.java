import java.io.File;
import java.util.Scanner;

public class java_41596_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        System.out.println("Enter the file type (e.g., '.txt'):");
        String type = scanner.nextLine();

        File dir = new File(path);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(type));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found.");
        }
    }
}