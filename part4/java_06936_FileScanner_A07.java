import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06936_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Searching for files in " + dirPath);
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        System.out.println("Size: " + file.length() + " bytes");
                    }
                }
            } else {
                System.out.println("No files found in " + dirPath);
            }
        } else {
            System.out.println(dirPath + " is not a valid directory");
        }

        scanner.close();
    }
}