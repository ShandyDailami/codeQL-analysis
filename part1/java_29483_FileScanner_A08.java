import java.io.File;
import java.util.Scanner;

public class java_29483_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);

        File fileToFind = new File(directory, fileName);

        if (fileToFind.exists() && fileToFind.isFile()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}