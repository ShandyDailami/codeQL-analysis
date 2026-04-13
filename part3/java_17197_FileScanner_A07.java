import java.io.File;
import java.util.Scanner;

public class java_17197_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dirFile = new File(dirPath);

        if (dirFile.exists()) {
            File[] files = dirFile.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("The directory does not exist.");
        }
    }
}