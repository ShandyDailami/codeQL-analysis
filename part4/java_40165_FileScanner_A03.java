import java.io.File;
import java.util.Scanner;

public class java_40165_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter the file extension (without dot): ");
        String fileExtension = scanner.nextLine();

        File dir = new File(dirPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the specified extension.");
        }

        scanner.close();
    }
}