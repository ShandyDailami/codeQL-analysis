import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27281_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            printFiles(directory);
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }

    private static void printFiles(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFiles(file);
                }
            }
        }
    }
}