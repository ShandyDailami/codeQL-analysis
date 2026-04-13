import java.io.File;
import java.util.Scanner;

public class java_00790_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file you want to search:");
        String filename = scanner.nextLine();

        File file = new File(filename);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("The file exists and is a regular file");
            } else if (file.isDirectory()) {
                System.out.println("The file exists and is a directory");
            }
        } else {
            System.out.println("The file does not exist");
        }
    }
}