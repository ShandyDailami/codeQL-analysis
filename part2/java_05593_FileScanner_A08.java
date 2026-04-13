import java.io.File;
import java.util.Scanner;

public class java_05593_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.next();

        File dir = new File(dirPath);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Invalid directory path!");
        }
    }
}