import java.io.File;
import java.util.Scanner;

public class java_30158_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file name you are looking for:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);

        File fileToFind = new File(directory, fileName);

        if (fileToFind.exists()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}