import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38010_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Files in directory: " + dir.getAbsolutePath());
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files found in directory: " + dir.getAbsolutePath());
            }
        } else {
            System.out.println("Invalid directory: " + dir.getAbsolutePath());
        }
    }
}