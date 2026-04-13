import java.io.File;
import java.util.Scanner;

public class java_21602_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter file extension: ");
        String extension = scanner.nextLine();

        File dir = new File(dirPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(extension));

        if (files == null) {
            System.out.println("No files found with the specified extension");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        }
    }
}