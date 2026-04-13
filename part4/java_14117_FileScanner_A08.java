import java.io.File;
import java.util.Scanner;

public class java_14117_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File fileToSearch = new File(directory, fileName);

        if (fileToSearch.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }
    }
}