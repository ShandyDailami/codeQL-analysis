import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00767_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            String[] files = directory.list();
            for (String fileName : files) {
                File file = new File(directoryPath + "/" + fileName);
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
}