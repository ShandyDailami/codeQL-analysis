import java.io.File;
import java.util.Scanner;

public class java_31677_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        if (file.isFile() && file.canRead()) {
            System.out.println("File is not empty!");
            return;
        } else {
            System.out.println("File is either not a regular file or it's not readable!");
            return;
        }
    }
}