import java.io.File;
import java.util.Scanner;

public class java_12683_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isHidden()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}