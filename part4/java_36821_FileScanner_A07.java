import java.io.File;
import java.util.Scanner;

public class java_36821_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String extension = scanner.nextLine();

        File dir = new File(dirPath);

        File[] files = dir.listFiles((dir1, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Directory is empty.");
        }
    }
}