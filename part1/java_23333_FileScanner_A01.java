import java.io.File;
import java.util.Scanner;

public class java_23333_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);
        File[] hiddenFiles = directory.listFiles(file -> file.isHidden());

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                } else {
                    System.out.println("File: " + file.getPath());
                }
            }
        } else {
            System.out.println("Directory is empty!");
        }

        scanner.close();
    }
}