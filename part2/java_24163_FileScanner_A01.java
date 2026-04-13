import java.io.File;
import java.util.Scanner;

public class java_24163_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory");
            return;
        }

        System.out.println("Files in the directory: ");
        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files in the directory");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}