import java.io.File;
import java.util.Scanner;

public class java_04875_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file: ");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }
    }
}