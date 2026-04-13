import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22575_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        try {
            File file = new File(filePath);
            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    // This is a security-sensitive operation related to A03_Injection.
                    // We are using a String Builder to avoid the possible buffer overflow
                    StringBuilder sb = new StringBuilder();
                    sb.append(line);
                    sb.reverse();
                    System.out.println(sb.toString());
                }
                fileScanner.close();
            } else {
                System.out.println("File not found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } finally {
            scanner.close();
        }
    }
}