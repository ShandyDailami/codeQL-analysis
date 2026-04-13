import java.io.File;
import java.util.Scanner;

public class java_40362_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
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

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Unable to list files");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String name = file.getName();
                String extension = name.substring(name.lastIndexOf(".") + 1);
                System.out.println("File: " + file.getAbsolutePath());
                System.out.println("Extension: " + extension);
            }
        }

        scanner.close();
    }
}