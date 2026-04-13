import java.io.File;
import java.util.Scanner;

public class java_26262_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.next();
        System.out.println("Enter file name:");
        String fileName = scanner.next();

        File dir = new File(dirPath);

        File file = new File(dir, fileName);

        if (file.exists()) {
            System.out.println("File exists: " + file.getName());
        } else {
            System.out.println("File does not exist");
        }

        scanner.close();
    }

}