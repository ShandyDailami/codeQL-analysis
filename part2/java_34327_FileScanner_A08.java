import java.io.File;
import java.util.Scanner;

public class java_34327_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] secureFiles = directory.listFiles((dir, name) -> {
            File file = new File(dir, name);
            return file.canRead();
        });

        for (File file : secureFiles) {
            if (file.isFile()) {
                System.out.println("File: " + file.getPath());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getPath());
            }
        }

        scanner.close();
    }
}