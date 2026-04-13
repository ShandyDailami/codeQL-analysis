import java.io.File;
import java.util.Scanner;

public class java_31168_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory!");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Unable to list files from the directory!");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String name = file.getName();
                if (name.endsWith(".java")) {
                    System.out.println("Found Java file: " + name);
                }
            } else if (file.isDirectory()) {
                System.out.println("Found directory: " + name);
            }
        }
    }
}