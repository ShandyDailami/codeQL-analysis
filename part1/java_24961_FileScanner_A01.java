import java.io.File;
import java.util.Scanner;
import java.util.FileNotFoundException;

public class java_24961_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String path = scanner.nextLine();

        try {
            File file = new File(path);
            if (file.exists()) {
                printFiles(file, scanner);
            } else {
                System.out.println("Directory not found!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }

    private static void printFiles(File file, Scanner scanner) {
        if (file.isFile()) {
            System.out.println(file.getPath());
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFiles(f, scanner);
                }
            }
        }
    }
}