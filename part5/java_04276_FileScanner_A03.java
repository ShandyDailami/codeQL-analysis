import java.io.File;
import java.util.Scanner;

public class java_04276_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File: " + file.getName());
                        System.out.println("Absolute path: " + file.getAbsolutePath());
                        System.out.println("Readable: " + file.canRead());
                        System.out.println("Writable: " + file.canWrite());
                        System.out.println("Executable: " + file.canExecute());
                        System.out.println("---------------------------------");
                    }
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}