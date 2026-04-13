import java.io.File;
import java.util.Scanner;

public class java_23590_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        File directory = new File(dirPath);
        File file = new File(directory, fileName);

        if (file.exists()) {
            System.out.println("File found: " + file.getAbsolutePath());
        } else {
            System.out.println("File not found!");
        }
    }
}