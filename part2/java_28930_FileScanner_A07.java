import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_28930_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] listFiles = dir.listFiles();

            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("Reading file: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in directory " + dirPath);
            }
        } else {
            System.out.println("Directory " + dirPath + " does not exist or is not a directory");
        }
    }
}