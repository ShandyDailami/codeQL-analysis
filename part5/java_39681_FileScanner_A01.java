import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39681_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            listFiles(dir, scanner);
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }
    }

    private static void listFiles(File dir, Scanner scanner) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    listFiles(file, scanner);
                }
            }
        }
    }
}