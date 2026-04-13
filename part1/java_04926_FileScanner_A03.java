import java.io.File;
import java.util.Scanner;

public class java_04926_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File dir = new File(dirPath);

        File[] files = dir.listFiles((dir1, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getPath());
                }
            }
        }

        scanner.close();
    }
}