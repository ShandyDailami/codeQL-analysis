import java.io.File;
import java.util.Scanner;

public class java_17756_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the directory:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        System.out.println("Enter the name of the file to search:");
        String fileName = scanner.nextLine();
        File fileToSearch = new File(directory, fileName);

        if (fileToSearch.exists()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}