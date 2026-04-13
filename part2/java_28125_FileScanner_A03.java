import java.io.File;
import java.util.Scanner;

public class java_28125_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String extension = scanner.nextLine();

        File directory = new File(path);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with extension: " + extension);
        }

        scanner.close();
    }
}