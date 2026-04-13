import java.io.File;
import java.util.Scanner;

public class java_10824_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File file = new File(System.getProperty("user.home"), fileName);

        if (file.exists()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}