import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05195_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (directory.listFiles() == null) {
            System.out.println("No files in the directory");
            return;
        }

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            }
        }

        scanner.close();
    }
}