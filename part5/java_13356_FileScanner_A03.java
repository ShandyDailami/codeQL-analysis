import java.io.File;
import java.util.Scanner;

public class java_13356_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("File name: " + file.getName());
                System.out.println("File path: " + file.getPath());
                System.out.println("File size: " + file.length() + " bytes");
            } else {
                System.out.println("Not a file");
            }
        } else {
            System.out.println("File not found");
        }
    }
}