import java.io.File;
import java.util.Scanner;

public class java_22564_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();
        scanner.close();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] secureFiles = dir.listFiles((File dir, String name) -> {
            File file = new File(dir, name);
            return file.length() <= 80;
        });

        if (secureFiles != null) {
            for (File file : secureFiles) {
                System.out.println("File name: " + file.getName());
            }
        } else {
            System.out.println("No secure files found");
        }
    }
}