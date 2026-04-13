import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00086_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File directory = new File(dirPath);
        File fileToFind = new File(directory, fileName);

        if (fileToFind.exists()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}