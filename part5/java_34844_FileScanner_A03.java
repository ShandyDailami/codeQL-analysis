import java.io.File;
import java.util.Scanner;

public class java_34844_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory: ");
        String directory = scanner.next();
        System.out.print("Enter file name: ");
        String fileName = scanner.next();

        File file = new File(directory + "/" + fileName);

        if (file.exists() && file.isFile()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }

        scanner.close();
    }
}