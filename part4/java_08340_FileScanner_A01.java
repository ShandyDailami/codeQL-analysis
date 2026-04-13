import java.io.File;
import java.util.Scanner;

public class java_08340_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files in directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File name: " + file.getName());
                System.out.println("File path: " + file.getPath());
                System.out.println("File absolute path: " + file.getAbsolutePath());
                System.out.println("File size: " + file.length() + " bytes");
            }
        }
    }
}