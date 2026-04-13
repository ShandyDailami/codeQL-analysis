import java.io.File;
import java.util.Scanner;

public class java_01017_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = input.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else {
                        System.out.println("Directory: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files in directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}