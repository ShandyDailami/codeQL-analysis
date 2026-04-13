import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01227_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        File file = new File(path);
        if (file.exists()) {
            listFiles(file, scanner);
        } else {
            System.out.println("Invalid path");
        }
    }

    private static void listFiles(File directory, Scanner scanner) {
        File[] listFiles = directory.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    listFiles(file, scanner);
                } else {
                    System.out.println(file.getName());
                }
            }
        }
    }
}