import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_15506_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("List of files in " + dirPath);
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files found in the directory");
            }
        } else {
            System.out.println("The path specified does not exist or is not a directory");
        }

        scanner.close();
    }
}