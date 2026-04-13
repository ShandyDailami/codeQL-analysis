import java.io.File;
import java.util.Scanner;

public class java_29610_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        String[] list = directory.list();

        if (list == null) {
            System.out.println("No files found!");
        } else {
            for (String file : list) {
                System.out.println(file);
            }
        }
    }
}