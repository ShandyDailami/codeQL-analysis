import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_01313_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        FileScanner fileScanner = new FileScanner(new File(directoryPath));

        System.out.println("Enter the file name to search: ");
        String fileName = scanner.nextLine();

        File file = new File(directoryPath + "/" + fileName);
        if (file.exists()) {
            if (file.canRead()) {
                fileScanner.scan(file, false);
            } else {
                System.out.println("Error: The file cannot be read.");
            }
        } else {
            System.out.println("Error: The file does not exist.");
        }

        fileScanner.close();
    }
}