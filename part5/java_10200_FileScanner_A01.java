import java.io.File;
import java.util.Scanner;

public class java_10200_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File Name: " + file.getName());
                }
           
            }
        } else {
            System.out.println("Directory not found");
        }

        scanner.close();
    }
}