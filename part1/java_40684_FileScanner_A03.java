import java.io.File;
import java.util.Scanner;

public class java_40684_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file to scan: ");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        if (!file.canRead()) {
            System.out.println("Cannot read the file!");
            return;
       
        }

        System.out.println("Reading file content: ");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }
        fileScanner.close();
    }
}