import java.io.File;
import java.util.Scanner;

public class java_25899_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter file extension: ");
        String fileExtension = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((dir1, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files found with extension " + fileExtension);
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}