import java.io.File;
import java.util.Scanner;

public class java_30495_FileScanner_A01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists()) {
            if (dir.isDirectory()) {
                System.out.println("Scanning files in directory: " + dirPath);
                File[] files = dir.listFiles();

                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        // You can add here the code to handle file (like reading a file, writing to another, etc.)
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                        // You can add here the code to handle directory (like listing its contents, etc.)
                   
                    }
                }
            } else {
                System.out.println(dirPath + " is not a directory");
            }
        } else {
            System.out.println("The specified directory does not exist");
        }
    }
}