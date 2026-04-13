import java.io.File;
import java.util.Scanner;

public class java_30055_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No .txt files found in the directory");
        }

        scanner.close();
    }
}