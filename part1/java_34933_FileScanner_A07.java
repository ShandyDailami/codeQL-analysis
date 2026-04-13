import java.io.File;
import java.util.Scanner;

public class java_34933_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File Name: " + file.getName());
                    System.out.println("File Path: " + file.getAbsolutePath());
                    System.out.println("File Size: " + file.length() + " bytes");
                } else if (file.isDirectory()) {
                    System.out.println("Directory Name: " + file.getName());
                    System.out.println("Directory Path: " + file.getAbsolutePath());
                }
           
            }
        } else {
            System.out.println("The directory does not exist or is not a directory.");
        }
    }
}