import java.io.File;
import java.util.Scanner;

public class java_00569_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] hiddenFiles = directory.listFiles((dir, name) -> name.startsWith("."));

            if (hiddenFiles != null) {
                for (File file : hiddenFiles) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    }
                }
            } else {
                System.out.println("No hidden files found.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}