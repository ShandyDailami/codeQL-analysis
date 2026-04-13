import java.io.File;
import java.util.Scanner;

public class java_22293_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                System.out.println("Scanning files in: " + directory.getAbsolutePath());
                FileScanner fileScanner = directory.listFiles();
                while (fileScanner != null) {
                    if (fileScanner.isFile()) {
                        System.out.println(fileScanner.getAbsolutePath());
                    }
                    fileScanner = fileScanner.nextFile();
                }
            } else {
                System.out.println(directory.getAbsolutePath() + " is not a directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}