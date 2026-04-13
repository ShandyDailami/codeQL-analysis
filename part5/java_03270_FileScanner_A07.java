import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03270_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner fileScanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = fileScanner.nextLine();
        fileScanner.close();

        try {
            File file = new File(filePath);
            Scanner fileScannerSecure = new Scanner(file);

            while (fileScannerSecure.hasNextLine()) {
                String line = fileScannerSecure.nextLine();
                System.out.println(line);
            }
            fileScannerSecure.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}