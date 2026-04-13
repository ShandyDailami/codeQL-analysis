import java.io.File;
import java.util.Scanner;

public class java_07000_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files in directory");
            }
        } else {
            System.out.println("Directory not found");
        }

        scanner.close();
    }
}