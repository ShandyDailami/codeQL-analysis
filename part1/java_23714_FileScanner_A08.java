import java.io.File;
import java.util.Scanner;

public class java_23714_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.isDirectory()) {
            System.out.println("Listing files in " + directory.getPath());
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Not a valid directory!");
        }

        scanner.close();
    }
}