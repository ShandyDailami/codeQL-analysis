import java.io.File;
import java.util.Scanner;

public class java_06661_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        if (file.exists()) {
            if (file.canRead()) {
                System.out.println("File found and can be read");
            } else {
                System.out.println("File found but can't be read");
            }
        } else {
            System.out.println("File not found");
        }

        scanner.close();
    }
}