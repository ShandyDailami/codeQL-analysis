import java.io.File;
import java.util.Scanner;

public class java_37039_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (!file.canRead()) {
                            System.out.println("Access to " + file.getPath() + " is blocked by security measures.");
                        } else {
                            System.out.println("Access to " + file.getPath() + " is permitted.");
                        }
                    }
                }
            } else {
                System.out.println("No files found in " + directoryPath);
            }
        } else {
            System.out.println(directoryPath + " is not a valid directory.");
        }

        scanner.close();
    }
}