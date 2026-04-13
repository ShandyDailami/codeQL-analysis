import java.io.File;
import java.util.Scanner;

public class java_12357_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter file type (for example: .txt): ");
        String fileType = scanner.nextLine();

        File directory = new File(dirPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileType));

        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    System.out.println("File found: " + file.getAbsolutePath());
                } else {
                    System.out.println("File is not readable: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Directory not found");
        }
    }
}