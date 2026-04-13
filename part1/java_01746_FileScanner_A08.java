import java.io.File;
import java.util.Scanner;

public class java_01746_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));
        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No .txt files found");
        }
    }
}