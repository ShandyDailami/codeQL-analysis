import java.io.File;
import java.util.Scanner;

public class java_10988_FileScanner_A01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.isDirectory()) {
            listFiles(directory);
        } else {
            System.out.println("Not a directory");
        }

        scanner.close();
    }

    private static void listFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    listFiles(file);
                }
            }
        }
    }
}