import java.io.File;
import java.util.Scanner;

public class java_04836_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        scanner.close();

        File file = new File(fileName);

        if (file.exists()) {
            System.out.println("File content:");
            System.out.println(file.getAbsolutePath());
        } else {
            System.out.println("File not found.");
        }
    }
}