import java.io.File;
import java.util.Scanner;

public class java_36969_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.canRead()) {
                        System.out.println("File: " + file.getName());
                    } else {
                        System.out.println("File: " + file.getName() + " - Can't be read.");
                    }
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }
    }
}