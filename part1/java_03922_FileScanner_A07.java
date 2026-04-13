import java.io.File;
import java.util.Scanner;

public class java_03922_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter file name pattern: ");
        String filePattern = scanner.nextLine();

        File dir = new File(dirPath);

        File[] files = dir.listFiles((File pathname) -> pathname.getName().matches(filePattern));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found that match the pattern.");
        }

        scanner.close();
    }
}