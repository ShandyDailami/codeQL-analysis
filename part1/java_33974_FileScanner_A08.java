import java.io.File;
import java.util.Scanner;

public class java_33974_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("The path does not exist or is not a directory.");
        }

        scanner.close();
    }
}