import java.io.File;
import java.util.Scanner;

public class java_33873_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("File found: " + file.getName());
            } else {
                System.out.println("Not a file");
            }
        } else {
            System.out.println("File not found");
        }

        scanner.close();
    }
}