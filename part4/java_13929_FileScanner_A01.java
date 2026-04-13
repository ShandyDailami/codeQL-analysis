import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_13929_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File file = new File(directoryPath + "/" + fileName);

        try {
            if (!file.exists()) {
                System.out.println("File does not exist!");
            } else if (file.isFile()) {
                System.out.println("It is a file!");
            } else if (file.isDirectory()) {
                System.out.println("It is a directory!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while checking the file.");
        }
    }
}