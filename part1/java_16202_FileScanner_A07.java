import java.io.File;
import java.util.Scanner;

public class java_16202_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        File file = new File(filePath);

        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    System.out.println("File exists and is readable.");
                } else {
                    System.out.println("File exists but is not readable.");
                }
            } else {
                System.out.println("Provided path is not a file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}