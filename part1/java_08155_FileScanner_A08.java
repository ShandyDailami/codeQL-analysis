import java.io.File;
import java.util.Scanner;

public class java_08155_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        System.out.println("Enter the prefix:");
        String prefix = scanner.nextLine();

        File directory = new File(dirPath);

        File[] files = directory.listFiles((dir, name) -> name.startsWith(prefix));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the given prefix.");
        }
    }
}