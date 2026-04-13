import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_02756_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String fileName = scanner.nextLine();
        File file = new File(fileName);

        try {
            if (file.canRead()) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            } else {
                System.out.println("You don't have permission to read the file. Please provide a correct file name.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}