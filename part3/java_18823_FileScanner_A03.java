import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18823_FileScanner_A03 {

    // A03_Injection: Use of Scanner to bypass user input
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            dirListFiles(dir);
        } else {
            System.out.println("Invalid directory path!");
        }
    }

    private static void dirListFiles(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    dirListFiles(file);
                }
            }
        }
    }
}