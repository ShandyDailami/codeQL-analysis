import java.io.File;
import java.util.Scanner;

public class java_05306_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        printDirectoryContents(new File(path));
    }

    public static void printDirectoryContents(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printDirectoryContents(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}